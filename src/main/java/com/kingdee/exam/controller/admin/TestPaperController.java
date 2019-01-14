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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class TestPaperController {
	
	@Autowired
	private TestPaperService testPaperService;
	@Autowired
	private QuestionBankMapper questionBankMapper;
	@Autowired
	private TestPaperTestService testPaperTestService;
	@Autowired
	private TestPaperMapper testPaperController;
	
	
	//查询数据库中有效试卷
	@RequestMapping(value="/testPaper.html")
	public ModelAndView findTestPaperInfo(){
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("_admin/test-paper"); 
		return modelAndView;
		
	}
	
	//获取所有试卷内容
	@ResponseBody
	@RequestMapping(value = "/getalltestpaper")
	public List<TestPaper> getAllTestPaper() {
		List<TestPaper> testPaper = testPaperService.findTestPaperInfo();
		return testPaper;
	}
	
	//更改试卷状态 即为删除
	@RequestMapping(value="/testDelete",method=RequestMethod.GET)
	@ResponseBody
	public String updateTestPaperInfo(String testpaperId){
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
	public ModelAndView editTestPaperInfo(HttpServletRequest request, HttpServletResponse response){
		int testpaperId=Integer.parseInt(request.getParameter("testpaperId"));
		TestPaper testPaper=testPaperService.selectByPrimaryKey(testpaperId);
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("testPaper", testPaper);
    	modelAndView.setViewName("_admin/editTestPapperInfo");
    	
    	return modelAndView;
	}
    @RequestMapping(value = "/testPaperEdit")
    @ResponseBody
    public String userEdti(TestPaper testPaper)throws Exception{

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
		
		List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
		
		return findAllQuestionBank;
	}
    
    @RequestMapping(value = "/addaddtestpaer")
    public boolean addTestPaer() {
    	
    	return true;
    }
    
    @RequestMapping(value="/editItemList.html")
    @ResponseBody
    public ModelAndView editItemList(String testpaperId){
    	List<QuestionBankVo> findAllQuestionBank = questionBankMapper.findAllQuestionBank();
    	List<TestPaperTestsVo> selectIdTestPaperQuesion=testPaperTestService.findSelectTestPaperQuesion(Integer.parseInt(testpaperId));
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("findAllQuestionBank", findAllQuestionBank);
    	modelAndView.addObject("selectIdTestPaperQuesion", selectIdTestPaperQuesion);
    	modelAndView.setViewName("_admin/editItemList");   	
    	return modelAndView;
    }
    
    //修改试卷试题
    @RequestMapping(value="/editTestPaperQuestion")
    @ResponseBody
    public String editTestPaperQuestion(@RequestBody TestPaperTestsList testPaperTestsList, HttpServletRequest request, HttpServletResponse response){
    	int j=testPaperTestService.deleteTestPaperTestById(testPaperTestsList.getTestpaperId());
    	int addTestPaperQuestion = testPaperTestService.addTestPaperQuestion(testPaperTestsList);
    	System.out.println(addTestPaperQuestion);
    	if(addTestPaperQuestion>=1){
    		return "1";
    	}else{
    		return "0";
    	}
    	
    }
    
    @ResponseBody
    @RequestMapping(value = "/addtestpaper")
    public boolean addTestPaper(TestPaper testPaper) {
    	testPaper.setTestpaperState(1);
    	int insertSelective = testPaperController.insertSelective(testPaper);
    	if (insertSelective>=1) {
			return true;
		}
    	return false;
    }


}
