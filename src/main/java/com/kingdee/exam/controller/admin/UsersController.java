package com.kingdee.exam.controller.admin;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class UsersController {
	
	@Autowired
	private UsersService usersService;
	
	/**
	 * 1.首页访问用户界面 对应下面  /user.html
	 * 2.查询页面用户数据
	 * @return
	 */
	@RequestMapping(value="/user.html",method=RequestMethod.GET)
	public ModelAndView AllUsers(){
		List<User> allUsers=usersService.findUserInfo();	//2.查询页面用户数据
		System.out.println("---------------------");
		System.out.println(allUsers);
		System.out.println("---------------------");
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.addObject("allUsers", allUsers);
    	modelAndView.setViewName("_admin/user"); 
		return modelAndView;
	}
	
	@RequestMapping(value="/userDelete",method=RequestMethod.GET)
	@ResponseBody
	public String deleteUsers(String userId){
		int i=usersService.deleteByPrimaryKey(userId);
		System.out.println(i);
			if(i>=1){
				return "1";
			}else{
				return "0";
			}
		
	}

	/**
	 * 添加账号
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "/adduser")
	public boolean addQuestionBank(@RequestBody User user) {
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		user.setEnabled(true);
		user.setRoles("ROLE_USER");
		return usersService.addUser(user);
	}


}
