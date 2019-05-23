package com.kingdee.exam.controller.exam;

import com.kingdee.exam.dao.ScoreMapper;
import com.kingdee.exam.entity.Score;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.service.ExamService;
import com.kingdee.exam.util.HttpSessionParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/exam")
public class ExamController {
    private final ScoreMapper scoreMapper;
    private final ExamService examService;

    @Autowired
    public ExamController(ExamService examService, ScoreMapper scoreMapper) {
        this.examService = examService;
        this.scoreMapper = scoreMapper;
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
     * 鼠标移出考试界面
     * @return 剩余可移出次数
     */
    @ResponseBody
    @RequestMapping(value = "/mouseLeave", method = RequestMethod.POST)
    public int mouseLeave(HttpSession session) {
        int mouseLeave=(int)session.getAttribute("mouseLeave");
        if(mouseLeave==0){
            return 0;
        }else {
            mouseLeave = mouseLeave - 1;
        }
        if(mouseLeave==0){//移出次数等于0了，直接给0分
            Score record = new Score();
            User users = HttpSessionParser.getCurrentUser(session);
            record.setTestpaperId(Integer.parseInt(session.getAttribute("testpaperId").toString()));
            record.setUsersId(users.getUserId());
            record.setFraction(0.0);
            scoreMapper.insertSelective(record);
        }
        session.setAttribute("mouseLeave",mouseLeave);
        return mouseLeave;
    }

}
