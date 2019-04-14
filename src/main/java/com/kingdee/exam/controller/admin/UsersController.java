package com.kingdee.exam.controller.admin;

import com.github.pagehelper.PageInfo;
import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/admin")
public class UsersController {
	
	private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    /**
	 * 1.首页访问用户界面 对应下面  /user.html
	 * 2.查询页面用户数据
	 */
	@RequestMapping(value="/user.html")
	public ModelAndView AllUsers(){
		ModelAndView modelAndView = new ModelAndView();
    	modelAndView.setViewName("_admin/user");
		return modelAndView;
	}
    /**
     * 获取所有实体
     */
    @ResponseBody
    @RequestMapping(value = "/getAllUser")
    public List<User> getAllUser(@RequestBody PageInfo<User> pageInfo) {
        return usersService.findUserInfo();
    }
	@PostMapping(value="/userDelete")
	@ResponseBody
	public boolean deleteUsers(@RequestBody String userId){
        return usersService.deleteByPrimaryKey(userId) >= 1;
	}
    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public boolean updateUser(@RequestBody User user) {
//        questionBankVo.setQuestionBankId(Integer.parseInt(id));
        return usersService.updateUser(user);
    }
	/**
	 * 添加账号
	 */
	@ResponseBody
	@RequestMapping(value = "/addUser")
	public Object addUser(@RequestBody User user) {
        if("".equals(user.getUsername()) ||user.getUsername()==null) {
            user.setUsername(user.getPhone());
        }
	    String password=makeRandomPassword(8);
		user.setPassword(new BCryptPasswordEncoder().encode(password));
		user.setEnabled(true);
		Map<String,String> resultMap=new HashMap<>();
		if(usersService.getUserByUsername(user.getUsername())!=null){
            resultMap.put("isSuccessfully","false");
            resultMap.put("message","用户名已存在");
        }else if(usersService.addUser(user)){
            resultMap.put("isSuccessfully","true");
            resultMap.put("userName",user.getUsername());
            resultMap.put("password",password);
            resultMap.put("trueName",user.getTrueName());
        }else{
            resultMap.put("isSuccessfully","false");
        }

		return resultMap;
	}

    //随机密码生成
    public static String makeRandomPassword(int len){
        char charr[] = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random r = new Random();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}
