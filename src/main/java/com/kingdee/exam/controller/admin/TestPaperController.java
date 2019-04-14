package com.kingdee.exam.controller.admin;

import com.kingdee.exam.dao.QuestionBankMapper;
import com.kingdee.exam.dao.TestPaperMapper;
import com.kingdee.exam.entity.TestPaper;
import com.kingdee.exam.entity.TestPaperTestsList;
import com.kingdee.exam.entity.vo.QuestionBankVo;
import com.kingdee.exam.entity.vo.TestPaperTestsVo;
import com.kingdee.exam.service.TestPaperService;
import com.kingdee.exam.service.TestPaperTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping("/admin")
public class TestPaperController {
	
	private final TestPaperService testPaperService;
	private final QuestionBankMapper questionBankMapper;
	private final TestPaperTestService testPaperTestService;
	private final TestPaperMapper testPaperController;

    @Autowired
    public TestPaperController(TestPaperService testPaperService, QuestionBankMapper questionBankMapper, TestPaperTestService testPaperTestService, TestPaperMapper testPaperController) {
        this.testPaperService = testPaperService;
        this.questionBankMapper = questionBankMapper;
        this.testPaperTestService = testPaperTestService;
        this.testPaperController = testPaperController;
    }


    //查询数据库中有效试卷
	@RequestMapping(value="/testPaper.html")
	public ModelAndView findTestPaperInfo(){
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("_admin/test-paper"); 
		return modelAndView;
		
	}
	
	//获取所有试卷
	@ResponseBody
	@RequestMapping(value = "/getalltestpaper")
	public List<TestPaper> getAllTestPaper() {
        return testPaperService.getAllTestPaper();
	}
	
	//删除试卷
	@RequestMapping(value="/testDelete",method=RequestMethod.GET)
	@ResponseBody
	public String updateTestPaperInfo(String testpaperId){
		int i=testPaperService.deleteTestPaper(Integer.parseInt(testpaperId));
		if(i>=1){
			return "1";
		}else{
			return "0";
		}
           
	}
	//更改试卷状态
	@RequestMapping(value="/updateTestPaperStatus",method=RequestMethod.GET)
	@ResponseBody
	public String updateTestPaperStatus(String testpaperId){
		int i=testPaperService.updateTestPaperState(Integer.parseInt(testpaperId));
		if(i>=1){
			return "1";
		}else{
			return "0";
		}

	}

	//编辑试卷信息
	@RequestMapping(value="/editTestPaperInfo.html")
	@ResponseBody
	public ModelAndView editTestPaperInfo(HttpServletRequest request){
		int testpaperId=Integer.parseInt(request.getParameter("testpaperId"));
		TestPaper testPaper=testPaperService.selectByPrimaryKey(testpaperId);
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("testPaper", testPaper);
    	modelAndView.setViewName("_admin/editTestPapperInfo");
    	
    	return modelAndView;
	}
    @RequestMapping(value = "/testPaperEdit")
    @ResponseBody
    public String userEdti(TestPaper testPaper) {

    	int j=testPaperService.updateTestPaperInfo(testPaper);
    	if (j >= 1) {
			return "1";
		}
    	return "0";

    }
/*	
    @RequestMapping(value="/testDelete",method=RequestMethod.GET)
	@ResponseBody
	public String deleteTestPaper(String testpaperId){
    	int i = testPaperService.deleteTestPaper(testpaperId);
    	System.out.println(i);
			if(i>=1){
				return "1";
			}else{
				return "0";
			}
		
	}
*/	
    
    @ResponseBody
    @RequestMapping(value = "/findalltestpager")
	public List<QuestionBankVo> findAllQuestionBank() {
        return questionBankMapper.findAllQuestionBank();
	}
    
    @RequestMapping(value = "/addaddtestpaer")
    public boolean addTestPaer() {
    	
    	return true;
    }
    
    @RequestMapping(value="/editItemList.html")
    @ResponseBody
    public ModelAndView editItemList(String testpaperId){
    	List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
    	List<TestPaperTestsVo> selectIdTestPaperQuestion=testPaperTestService.findSelectTestPaperQuesion(Integer.parseInt(testpaperId));
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("findAllQuestionBank", findAllQuestionBank);
    	modelAndView.addObject("selectIdTestPaperQuesion", selectIdTestPaperQuestion);
    	modelAndView.setViewName("_admin/editItemList");   	
    	return modelAndView;
    }

    @RequestMapping(value="/getAllQuestions")
    @ResponseBody
    public Object getAllQuestions(String testpaperId){
        List<QuestionBankVo> AllQuestionBank = questionBankMapper.findAllQuestionBank();
        List<TestPaperTestsVo> selectIdTestPaperQuestion=testPaperTestService.findSelectTestPaperQuesion(Integer.parseInt(testpaperId));
        Map<String,List<?>> resultMap=new HashMap<>();
        resultMap.put("allQuestionBank", AllQuestionBank);
        resultMap.put("selectIdTestPaperQuestion", selectIdTestPaperQuestion);
        return resultMap;
    }
    //修改试卷试题
    @RequestMapping(value="/editTestPaperQuestion")
    @ResponseBody
    public String editTestPaperQuestion(@RequestBody TestPaperTestsList testPaperTestsList){
    	testPaperTestService.deleteTestPaperTestById(testPaperTestsList.getTestpaperId());
    	int addTestPaperQuestion = testPaperTestService.addTestPaperQuestion(testPaperTestsList);
    	System.out.println(addTestPaperQuestion);
    	if(addTestPaperQuestion>=1){
    		return "1";
    	}else{
    		return "0";
    	}
    	
    }

    //一键自动出题
    @RequestMapping(value="/autoChoiceQuestion")
    @ResponseBody
    public boolean autoChoiceQuestion(Integer testPaperID){
        TestPaperTestsList testPaperTestsList=new TestPaperTestsList();
        testPaperTestsList.setTestpaperId(testPaperID);
        List<QuestionBankVo> AllQuestionBank = questionBankMapper.findAllQuestionBank();
        /*
         * 判断题=0
         * 选择题=1
         * 编程题=2
         */
        List<Integer> judgeQuestionsID = new ArrayList<>();
        List<Integer> choiceQuestionsID = new ArrayList<>();
        List<Integer> codingQuestionsID = new ArrayList<>();
        for (QuestionBankVo question:AllQuestionBank) {
            switch (question.getTestsType()){
                case 0:
                    judgeQuestionsID.add(question.getQuestionBankId());
                    break;
                case 1:
                    choiceQuestionsID.add(question.getQuestionBankId());
                    break;
                case 2:
                    codingQuestionsID.add(question.getQuestionBankId());
                    break;
            }
        }
        List<Integer> questionBankId = new ArrayList<>();
        Collections.shuffle(judgeQuestionsID);
        Collections.shuffle(choiceQuestionsID);
        Collections.shuffle(codingQuestionsID);
        //随机选5道判断题，5道选择题，1道编程题
        for(int i=0;i<5;i++){
            questionBankId.add(judgeQuestionsID.get(i));
            questionBankId.add(choiceQuestionsID.get(i));
        }
        questionBankId.add(codingQuestionsID.get(0));
        testPaperTestsList.setQuestionBankId(questionBankId);
        System.out.println(testPaperID);
        testPaperTestService.deleteTestPaperTestById(testPaperID);
        int addTestPaperQuestion = testPaperTestService.addTestPaperQuestion(testPaperTestsList);
        return addTestPaperQuestion >= 1;
    }
    @ResponseBody
    @RequestMapping(value = "/addtestpaper")
    public boolean addTestPaper(TestPaper testPaper) {
    	testPaper.setTestpaperState(1);
    	int insertSelective = testPaperController.insertSelective(testPaper);
        return insertSelective >= 1;
    }


}
