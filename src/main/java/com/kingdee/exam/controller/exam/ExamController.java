package com.kingdee.exam.controller.exam;

import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/exam")
public class ExamController {

    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService) {
        this.examService = examService;
    }

    /**
     * 试卷模板映射
     */
    @RequestMapping(value = "/index.html", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView();

        List<TestPaper> allTestPaper = examService.findAllTestPaper();
        modelAndView.addObject("allTestPaper", allTestPaper);

        modelAndView.setViewName("_exam/index");
        return modelAndView;
    }

    /**
     * 试卷模板映射
     */
    @RequestMapping(value = "/exam-{id}.html")
    public ModelAndView exam(@PathVariable String id, HttpSession session) {
        ModelAndView modelAndView = new ModelAndView();
        examService.findJudgmentQuestionAndChoiceQuestion(modelAndView, id, session);
/*		List<TestPaper> allTestPaper = examService.findAllTestPaper();
		modelAndView.addObject("allTestPaper", allTestPaper);
*/
        return modelAndView;
    }


    @ResponseBody
    @RequestMapping(value = "/submitpapers", method = RequestMethod.POST)
    public Object submitPapers(@RequestBody List<QuestionBankVo> questionBankVos, HttpSession session) {
        return examService.JudgmentSystem(questionBankVos, session);
    }

    /**
     * 试卷模板映射
     */
    @ResponseBody
    @RequestMapping(value = "/autoGenerate", method = RequestMethod.POST)
    public boolean autoGenerate(HttpSession session, TestPaper testPaper) {
        return examService.autoGenerate(session, testPaper.getTestpaperId());
    }

}
