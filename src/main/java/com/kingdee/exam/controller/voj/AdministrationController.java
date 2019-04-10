package com.kingdee.exam.controller.voj;

import com.alibaba.fastjson.JSON;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.QuestionBankService;
import com.kingdee.exam.util.CsrfProtector;
import com.kingdee.exam.util.DateUtils;
import com.kingdee.exam.util.HttpRequestParser;
import com.kingdee.exam.voj.exception.ResourceNotFoundException;
import com.kingdee.exam.voj.model.Checkpoint;
import com.kingdee.exam.voj.model.Problem;
import com.kingdee.exam.voj.model.ProblemCategory;
import com.kingdee.exam.voj.model.Submission;
import com.kingdee.exam.voj.service.ProblemService;
import com.kingdee.exam.voj.service.SubmissionService;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 用于处理系统管理的请求.
 */
@Controller
@RequestMapping(value = "/administration")
public class AdministrationController {
    private final ProblemService problemService;
    private final SubmissionService submissionService;
    private final QuestionBankService questionBankService;
    private static final Logger LOGGER = LogManager.getLogger(AdministrationController.class);

    @Autowired
    public AdministrationController(ProblemService problemService, SubmissionService submissionService, QuestionBankService questionBankService) {
        this.problemService = problemService;
        this.submissionService = submissionService;
        this.questionBankService = questionBankService;
    }

    /**
     * 获取系统一段时间内的提交次数.
     *
     * @param period  - 时间间隔的天数
     * @return 包含提交次数与时间的 Map 对象
     */
    @RequestMapping(value = "/getNumberOfSubmissions.action", method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> getNumberOfSubmissionsAction(
            @RequestParam(value = "period") int period) {
        Map<String, Object> submissions = new HashMap<>(2, 1);
        Date today = new Date();
        Date previousDate = DateUtils.getPreviousDate(period);
        Map<String, Long> totalSubmissions = submissionService.getNumberOfSubmissionsUsingDate(previousDate, today, 0, false);
        Map<String, Long> acceptedSubmissions = submissionService.getNumberOfSubmissionsUsingDate(previousDate, today, 0, true);

        submissions.put("totalSubmissions", totalSubmissions);
        submissions.put("acceptedSubmissions", acceptedSubmissions);
        return submissions;
    }

    /**
     * 加载试题列表页面.
     *
     * @return 包含提交列表页面信息的ModelAndView对象
     */
    @RequestMapping(value = "/all-problems", method = RequestMethod.GET)
    public ModelAndView allProblemsView(
            @RequestParam(value = "keyword", required = false, defaultValue = "") String keyword,
            @RequestParam(value = "problemCategory", required = false, defaultValue = "") String problemCategorySlug,
            @RequestParam(value = "page", required = false, defaultValue = "1") long pageNumber) {
        final int NUMBER_OF_PROBLEMS_PER_PAGE = 100;
        List<ProblemCategory> problemCategories = problemService.getProblemCategories();
        long totalProblems = problemService.getNumberOfProblemsUsingFilters(keyword, problemCategorySlug, false);

        long offset = (pageNumber >= 1 ? pageNumber - 1 : 0) * NUMBER_OF_PROBLEMS_PER_PAGE;
        long problemIdLowerBound = problemService.getFirstIndexOfProblems() + offset;
        long problemIdUpperBound = problemIdLowerBound + NUMBER_OF_PROBLEMS_PER_PAGE - 1;

        List<Problem> problems = problemService.getProblemsUsingFilters(problemIdLowerBound, keyword, problemCategorySlug, false, NUMBER_OF_PROBLEMS_PER_PAGE);
        Map<Long, List<ProblemCategory>> problemCategoryRelationships =
                problemService.getProblemCategoriesOfProblems(problemIdLowerBound, problemIdUpperBound);

        ModelAndView view = new ModelAndView("administration/all-problems");
        view.addObject("problemCategories", problemCategories);
        view.addObject("selectedProblemCategory", problemCategorySlug);
        view.addObject("keyword", keyword);
        view.addObject("currentPage", pageNumber);
        view.addObject("totalPages", (long) Math.ceil(totalProblems * 1.0 / NUMBER_OF_PROBLEMS_PER_PAGE));
        view.addObject("problems", problems);
        view.addObject("problemCategoryRelationships", problemCategoryRelationships);
        return view;
    }

    /**
     * 删除选定的试题.
     *
     * @param problems - 试题ID的集合, 以逗号(, )分隔
     * @param request  - HttpServletRequest对象
     * @return 试题的删除结果
     */
    @RequestMapping(value = "/deleteProblems.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Boolean> deleteProblemsAction(
            @RequestParam(value = "problems") String problems,
            HttpServletRequest request) {
        Map<String, Boolean> result = new HashMap<>(2, 1);
        List<Long> problemList = JSON.parseArray(problems, Long.class);

        for (Long problemId : problemList) {
            problemService.deleteProblem(problemId);

            String ipAddress = HttpRequestParser.getRemoteAddr(request);
            LOGGER.info(String.format("Problem: [ProblemId=%s] was deleted by administrator at %s.",
                    problemId, ipAddress));
        }
        result.put("isSuccessful", true);
        return result;
    }

    /**
     * 加载创建试题页面.
     *
     * @return 包含创建试题页面信息的ModelAndView对象
     */
    @RequestMapping(value = "/new-problem", method = RequestMethod.GET)
    public ModelAndView newProblemView() {
        Map<ProblemCategory, List<ProblemCategory>> problemCategories = problemService.getProblemCategoriesWithHierarchy();

        ModelAndView view = new ModelAndView("administration/new-problem");
        view.addObject("problemCategories", problemCategories);
        return view;
    }

    /**
     * 处理用户创建试题的请求.
     *
     * @param problemName       - 试题名称
     * @param timeLimit         - 时间限制
     * @param memoryLimit       - 内存占用限制
     * @param description       - 试题描述
     * @param hint              - 试题提示
     * @param inputFormat       - 输入格式
     * @param outputFormat      - 输出格式
     * @param inputSample       - 输入样例
     * @param outputSample      - 输出样例
     * @param testCases         - 测试用例(JSON 格式)
     * @param problemCategories - 试题分类(JSON 格式)
     * @param isExactlyMatch    - 测试点是否精确匹配
     * @param request           - HttpServletRequest对象
     * @return 包含试题创建结果的 Map<String, Boolean>对象
     */
    @RequestMapping(value = "/createProblem.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> createProblemAction(
            @RequestParam(value = "problemName") String problemName,
            @RequestParam(value = "timeLimit") String timeLimit,
            @RequestParam(value = "memoryLimit") String memoryLimit,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "hint") String hint,
            @RequestParam(value = "inputFormat") String inputFormat,
            @RequestParam(value = "outputFormat") String outputFormat,
            @RequestParam(value = "inputSample") String inputSample,
            @RequestParam(value = "outputSample") String outputSample,
            @RequestParam(value = "testCases") String testCases,
            @RequestParam(value = "problemCategories") String problemCategories,
            @RequestParam(value = "isExactlyMatch") boolean isExactlyMatch,
            HttpServletRequest request) {
        if (timeLimit.isEmpty() || !StringUtils.isNumeric(timeLimit)) {
            timeLimit = "-1";
        }
        if (memoryLimit.isEmpty() || !StringUtils.isNumeric(memoryLimit)) {
            memoryLimit = "-1";
        }
        QuestionBankVo questionBankVo = new QuestionBankVo();
        questionBankVo.setAnswer("100");
        questionBankVo.setTestsType(2);
        questionBankVo.setStem(problemName);
        boolean addQuestionBank = questionBankService.addQuestionBank(questionBankVo);

        if (!addQuestionBank) {
            throw new ResourceNotFoundException();
        }
        Map<String, Object> result = problemService.createProblem(problemName, questionBankVo.getQuestionBankId(),
                Integer.parseInt(timeLimit), Integer.parseInt(memoryLimit), description, hint, inputFormat, outputFormat, inputSample,
                outputSample, testCases, problemCategories, isExactlyMatch);

        if ((boolean) result.get("isSuccessful")) {
            long problemId = (Long) result.get("problemId");
            String ipAddress = HttpRequestParser.getRemoteAddr(request);

            LOGGER.info(String.format("Problem: [ProblemId=%s] was created by administrator at %s.",
                    problemId, ipAddress));
        }
        return result;
    }

    /**
     * 加载编辑试题页面.
     *
     * @param problemId - 试题的唯一标识符
     * @return 包含提交列表页面信息的ModelAndView对象
     */
    @RequestMapping(value = "/edit-problem/{problemId}", method = RequestMethod.GET)
    public ModelAndView editProblemsView(
            @PathVariable(value = "problemId") long problemId) {
        Problem problem = problemService.getProblem(problemId);

        if (problem == null) {
            throw new ResourceNotFoundException();
        }
        List<Checkpoint> checkpoints = problemService.getCheckpointsUsingProblemId(problemId);
        List<ProblemCategory> selectedProblemCategories = problemService.getProblemCategoriesUsingProblemId(problemId);
        Map<ProblemCategory, List<ProblemCategory>> problemCategories = problemService.getProblemCategoriesWithHierarchy();

        ModelAndView view = new ModelAndView("administration/edit-problem");
        view.addObject("problem", problem);
        view.addObject("checkpoints", checkpoints);
        view.addObject("problemCategories", problemCategories);
        view.addObject("selectedProblemCategories", selectedProblemCategories);
        return view;
    }

    /**
     * 处理用户编辑试题的请求.
     *
     * @param problemName       - 试题名称
     * @param timeLimit         - 时间限制
     * @param memoryLimit       - 内存占用限制
     * @param description       - 试题描述
     * @param hint              - 试题提示
     * @param inputFormat       - 输入格式
     * @param outputFormat      - 输出格式
     * @param inputSample       - 输入样例
     * @param outputSample      - 输出样例
     * @param testCases         - 测试用例(JSON 格式)
     * @param problemCategories - 试题分类(JSON 格式)
     * @param isExactlyMatch    - 测试点是否精确匹配
     * @param request           - HttpServletRequest对象
     * @return 包含试题编辑结果的 Map<String, Boolean>对象
     */
    @RequestMapping(value = "/editProblem.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Boolean> editProblemAction(
            @RequestParam(value = "problemId") long problemId,
            @RequestParam(value = "problemName") String problemName,
            @RequestParam(value = "timeLimit") String timeLimit,
            @RequestParam(value = "memoryLimit") String memoryLimit,
            @RequestParam(value = "description") String description,
            @RequestParam(value = "hint") String hint,
            @RequestParam(value = "inputFormat") String inputFormat,
            @RequestParam(value = "outputFormat") String outputFormat,
            @RequestParam(value = "inputSample") String inputSample,
            @RequestParam(value = "outputSample") String outputSample,
            @RequestParam(value = "testCases") String testCases,
            @RequestParam(value = "problemCategories") String problemCategories,
            @RequestParam(value = "isExactlyMatch") boolean isExactlyMatch,
            @RequestParam(value = "questionBankId") int questionBankId,
            HttpServletRequest request) {
        if (timeLimit.isEmpty() || !StringUtils.isNumeric(timeLimit)) {
            timeLimit = "-1";
        }
        if (memoryLimit.isEmpty() || !StringUtils.isNumeric(memoryLimit)) {
            memoryLimit = "-1";
        }
        Map<String, Boolean> result = problemService.editProblem(problemId, questionBankId, problemName, Integer.parseInt(timeLimit),
                Integer.parseInt(memoryLimit), description, hint, inputFormat, outputFormat, inputSample,
                outputSample, testCases, problemCategories, isExactlyMatch);

        if (result.get("isSuccessful")) {
            String ipAddress = HttpRequestParser.getRemoteAddr(request);

            LOGGER.info(String.format("Problem: [ProblemId=%s] was edited by administrator at %s.",
                    problemId, ipAddress));
        }
        return result;
    }

    /**
     * 加载试题分类页面.
     *
     * @return 包含试题分类页面信息的ModelAndView对象.
     */
    @RequestMapping(value = "/problem-categories", method = RequestMethod.GET)
    public ModelAndView problemCategoriesView() {
        List<ProblemCategory> problemCategories = problemService.getProblemCategories();

        ModelAndView view = new ModelAndView("administration/problem-categories");
        view.addObject("problemCategories", problemCategories);
        return view;
    }

    /**
     * 创建试题分类.
     *
     * @param problemCategorySlug       - 试题分类的别名
     * @param problemCategoryName       - 试题分类的名称
     * @param parentProblemCategorySlug - 父级试题分类的别名
     * @param request                   - HttpServletRequest对象
     * @return 包含试题分类的创建结果的Map<String   ,       Object>对象
     */
    @RequestMapping(value = "/createProblemCategory.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> createProblemCategoryAction(
            @RequestParam(value = "problemCategorySlug") String problemCategorySlug,
            @RequestParam(value = "problemCategoryName") String problemCategoryName,
            @RequestParam(value = "parentProblemCategory") String parentProblemCategorySlug,
            HttpServletRequest request) {
        Map<String, Object> result = problemService.createProblemCategory(
                problemCategorySlug, problemCategoryName, parentProblemCategorySlug);

        if ((boolean) result.get("isSuccessful")) {
            long problemCategoryId = (Long) result.get("problemCategoryId");
            String ipAddress = HttpRequestParser.getRemoteAddr(request);

            LOGGER.info(String.format("ProblemCategory: [ProblemCategoryId=%s] was created by administrator at %s.",
                    problemCategoryId, ipAddress));
        }
        return result;
    }

    /**
     * 编辑试题分类.
     *
     * @param problemCategoryId         - 试题分类的唯一标识符
     * @param problemCategorySlug       - 试题分类的别名
     * @param problemCategoryName       - 试题分类的名称
     * @param parentProblemCategorySlug - 父级试题分类的别名
     * @param request                   - HttpServletRequest对象
     * @return 包含试题分类的编辑结果的Map<String   ,       Boolean>对象
     */
    @RequestMapping(value = "/editProblemCategory.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Boolean> editProblemCategoryAction(
            @RequestParam(value = "problemCategoryId") String problemCategoryId,
            @RequestParam(value = "problemCategorySlug") String problemCategorySlug,
            @RequestParam(value = "problemCategoryName") String problemCategoryName,
            @RequestParam(value = "parentProblemCategory") String parentProblemCategorySlug,
            HttpServletRequest request) {
        Map<String, Boolean> result = problemService.editProblemCategory(
                Integer.parseInt(problemCategoryId), problemCategorySlug,
                problemCategoryName, parentProblemCategorySlug);

        if (result.get("isSuccessful")) {
            String ipAddress = HttpRequestParser.getRemoteAddr(request);

            LOGGER.info(String.format("ProblemCategory: [ProblemCategoryId=%s] was edited by administrator at %s.",
                    problemCategoryId, ipAddress));
        }
        return result;
    }

    /**
     * 删除试题分类.
     *
     * @param problemCategories - 试题分类的唯一标识符集合
     * @param request           - HttpServletRequest对象
     * @return 包含试题分类的删除结果的Map<String   ,       Boolean>对象
     */
    @RequestMapping(value = "/deleteProblemCategories.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> deleteProblemCategoryAction(
            @RequestParam(value = "problemCategories") String problemCategories,
            HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(3, 1);
        List<Integer> problemCategoryList = JSON.parseArray(problemCategories, Integer.class);
        List<Integer> deletedProblemCategories = new ArrayList<>();

        for (int problemCategoryId : problemCategoryList) {
            if (problemService.deleteProblemCategory(problemCategoryId)) {
                deletedProblemCategories.add(problemCategoryId);
            }
            String ipAddress = HttpRequestParser.getRemoteAddr(request);
            LOGGER.info(String.format("ProblemCategory: [ProblemCategoryId=%s] was deleted by administrator at %s.",
                    problemCategoryId, ipAddress));
        }
        result.put("isSuccessful", true);
        result.put("deletedProblemCategories", deletedProblemCategories);
        return result;
    }

    /**
     * 加载提交列表页面.
     *
     * @param problemId  - 提交对应试题的唯一标识符
     * @param username   - 提交者的用户名
     * @param pageNumber - 当前页面的页码
     * @return 包含提交列表页面信息的ModelAndView对象
     */
    @RequestMapping(value = "/all-submissions", method = RequestMethod.GET)
    public ModelAndView allSubmissionsView(
            @RequestParam(value = "problemId", required = false, defaultValue = "0") long problemId,
            @RequestParam(value = "username", required = false, defaultValue = "") String username,
            @RequestParam(value = "page", required = false, defaultValue = "1") long pageNumber) {
        final int NUMBER_OF_SUBMISSIONS_PER_PAGE = 100;

        long totalSubmissions = submissionService.getNumberOfSubmissionsUsingProblemIdAndUsername(problemId, username);
        long latestSubmissionId = submissionService.getLatestSubmissionId();
        long offset = latestSubmissionId - (pageNumber >= 1 ? pageNumber - 1 : 0) * NUMBER_OF_SUBMISSIONS_PER_PAGE;
        List<Submission> submissions = submissionService.getSubmissions(problemId, username, offset, NUMBER_OF_SUBMISSIONS_PER_PAGE);

        ModelAndView view = new ModelAndView("administration/all-submissions");
        view.addObject("problemId", problemId);
        view.addObject("username", username);
        view.addObject("currentPage", pageNumber);
        view.addObject("totalPages", (long) Math.ceil(totalSubmissions * 1.0 / NUMBER_OF_SUBMISSIONS_PER_PAGE));
        view.addObject("submissions", submissions);
        return view;
    }

    /**
     * 删除选定的提交记录.
     *
     * @param submissions - 提交记录ID的集合, 以逗号(, )分隔
     * @param request     - HttpServletRequest对象
     * @return 提交记录的删除结果
     */
    @RequestMapping(value = "/deleteSubmissions.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> deleteSubmissionsAction(
            @RequestParam(value = "submissions") String submissions,
            HttpServletRequest request) {
        Map<String, Object> result = new HashMap<>(3, 1);
        List<Long> submissionList = JSON.parseArray(submissions, Long.class);
        List<Long> deletedSubmissions = new ArrayList<>();

        for (Long submissionId : submissionList) {
            if (submissionService.deleteSubmission(submissionId)) {
                deletedSubmissions.add(submissionId);
            }
            String ipAddress = HttpRequestParser.getRemoteAddr(request);
            LOGGER.info(String.format("Submission: [SubmissionId=%s] deleted by administrator at %s.",
                    submissionId, ipAddress));
        }
        result.put("isSuccessful", true);
        result.put("deletedSubmissions", deletedSubmissions);
        return result;
    }

    /**
     * 重新评测选定的提交记录.
     *
     * @param submissions - 提交记录ID的集合, 以逗号(, )分隔
     * @return 重新评测请求的执行结果
     */
    @RequestMapping(value = "/restartSubmissions.action", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Boolean> restartSubmissionsAction(
            @RequestParam(value = "submissions") String submissions) {
        Map<String, Boolean> result = new HashMap<>(2, 1);
        List<Long> submissionList = JSON.parseArray(submissions, Long.class);

        for (Long submissionId : submissionList) {
            submissionService.createSubmissionTask(submissionId);
        }
        result.put("isSuccessful", true);
        return result;
    }

    /**
     * 查看提交记录.
     *
     * @param submissionId - 提交记录的唯一标识符
     * @param request      - HttpServletRequest对象
     * @return 包含提交记录信息的ModelAndView对象
     */
    @RequestMapping(value = "/edit-submission/{submissionId}", method = RequestMethod.GET)
    public ModelAndView editSubmissionView(
            @PathVariable(value = "submissionId") long submissionId,
            HttpServletRequest request) {
        Submission submission = submissionService.getSubmission(submissionId);
        if (submission == null) {
            throw new ResourceNotFoundException();
        }
        ModelAndView view = new ModelAndView("administration/edit-submission");
        view.addObject("submission", submission);
        view.addObject("csrfToken", CsrfProtector.getCsrfToken(request.getSession()));
        return view;
    }

}
