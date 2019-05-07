package com.kingdee.exam.controller.voj;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.voj.exception.ResourceNotFoundException;
import com.kingdee.exam.voj.messenger.ApplicationEventListener;
import com.kingdee.exam.voj.model.Submission;
import com.kingdee.exam.voj.service.SubmissionService;
import com.kingdee.exam.util.HttpSessionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加载/显示评测的相关信息.
 */
@Controller
@RequestMapping(value="/submission")
public class SubmissionController {
    @Autowired
    public SubmissionController(SubmissionService submissionService, ApplicationEventListener submissionEventListener) {
        this.submissionService = submissionService;
        this.submissionEventListener = submissionEventListener;
    }

    /**
	 * 显示评测列表的页面.
	 * @param problemId - 试题的唯一标识符
	 * @param username - 用户的用户名
	 * @return 包含提交列表的ModelAndView对象
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView submissionsView(
            @RequestParam(value="problemId", required=false, defaultValue="0") long problemId,
            @RequestParam(value="username", required=false, defaultValue="") String username) {
		List<Submission> submissions = submissionService.getSubmissions(problemId, username, NUMBER_OF_SUBMISSION_PER_PAGE);
		return new ModelAndView("submissions/submissions")
					.addObject("submissions", submissions);
	}
	
	/**
	 * 获取历史评测信息的列表.
	 * @param problemId - 试题的唯一标识符
	 * @param username - 用户的用户名
	 * @param startIndex - 当前加载的最后一条记录的提交唯一标识符
	 * @return 一个包含提交记录列表的HashMap对象
	 */
	@RequestMapping(value="/getSubmissions.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getSubmissionsAction(
			@RequestParam(value="problemId", required=false, defaultValue="0") long problemId,
			@RequestParam(value="username", required=false, defaultValue="") String username,
			@RequestParam(value="startIndex") long startIndex) {
		Map<String, Object> result = new HashMap<>(3, 1);

		List<Submission> submissions = submissionService.getSubmissions(problemId, username, startIndex, NUMBER_OF_SUBMISSION_PER_PAGE);
		result.put("isSuccessful", submissions != null && !submissions.isEmpty());
		result.put("submissions", submissions);
		
		return result;
	}
	
	/**
	 * 显示提交记录详细信息的页面.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含提交详细信息的ModelAndView对象
	 */
	@RequestMapping(value="/{submissionId}", method=RequestMethod.GET)
	@ResponseBody
	public Object submissionView(
            @PathVariable("submissionId") long submissionId) {
		Submission submission = submissionService.getSubmission(submissionId);
		if ( submission == null ) {
			throw new ResourceNotFoundException();
		}
		return submission;
	}
	
	/**
	 * 获取实时的评测结果.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含评测结果信息的StreamingResponseBody对象
	 */
	@RequestMapping("/getRealTimeJudgeResult.action")
	public SseEmitter getRealTimeJudgeResultAction(
            @RequestParam(value="submissionId") long submissionId,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
		User currentUser = HttpSessionParser.getCurrentUser(request.getSession());
		Submission submission = submissionService.getSubmission(submissionId);
		if ( submission == null ||
				!submission.getUser().equals(currentUser) ||
				!submission.getJudgeResult().getJudgeResultSlug().equals("PD") ) {
			throw new ResourceNotFoundException();
		}
		
		response.addHeader("X-Accel-Buffering", "no");
		SseEmitter sseEmitter = new SseEmitter();
		submissionEventListener.addSseEmitters(submissionId, sseEmitter);
		sseEmitter.send("Established");
		return sseEmitter;
	}
	
	/**
	 * 获取提交记录的详细信息.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含提交记录详细信息的HashMap对象
	 */
	@RequestMapping(value="/getSubmission.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getSubmissionAction(
            @RequestParam(value = "submissionId") long submissionId) {
		Map<String, Object> result = new HashMap<>(3, 1);

		Submission submission = submissionService.getSubmission(submissionId);
		result.put("isSuccessful", submission != null);
		result.put("submission", submission);

		return result;
	}
	
	/**
	 * 每次请求所加载评测记录的数量.
	 */
	private static final int NUMBER_OF_SUBMISSION_PER_PAGE = 100;
	
	private final SubmissionService submissionService;
	
	private final ApplicationEventListener submissionEventListener;
}
