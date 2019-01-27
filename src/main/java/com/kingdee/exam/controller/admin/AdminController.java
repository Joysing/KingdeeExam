package com.kingdee.exam.controller.admin;

import com.kingdee.exam.dao.AdminMapper;
import com.kingdee.exam.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

	@Autowired
	private AdminMapper adminMapper;

	/**
	 * 映射主页模板
	 * 
	 * @return
	 */
	@GetMapping("/login")
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
							  @RequestParam(value = "logout", required = false) String logout) {
		ModelAndView modelAndView = new ModelAndView();
		if (error != null) {
			modelAndView.addObject("error", "不正确的用户名和密码");
		}
		if (logout != null) {
			modelAndView.addObject("msg", "你已经成功退出");
		}
		modelAndView.setViewName("login");
		return modelAndView;
	}

    @GetMapping(value="/logout")
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }

	public User getUser() { //为了session从获取用户信息,可以配置如下
		User user = new User();
		SecurityContext ctx = SecurityContextHolder.getContext();
		Authentication auth = ctx.getAuthentication();
		if (auth.getPrincipal() instanceof UserDetails) user = (User) auth.getPrincipal();
		return user;
	}
	/**
	 * 登陆接受JSON数据
	 * 
	 * @param req
	 * @param users
	 * @return
	 */
	@ResponseBody
	@PostMapping("/login1")
	public String loginJson(HttpServletRequest req, User users) {
		HttpSession session=req.getSession();
//		String sessionCode = (String) session.getAttribute("code");// session中验证码
		String code = users.getCode();// 用户code
//		System.out.println("session中验证码:"+sessionCode);
//		if (!code.equals(sessionCode)) {// 验证码错误返回提示信息
//			System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊:0");
//			return "0";
//		}

		User user = adminMapper.findByUser(users);
		if (user != null) {
			session.setAttribute("myUser", user);// 存SESSION
			String role=user.getRoles();
			if (role.contentEquals("ROLE_ADMIN")) {
				// 跳转管理员
				return "2";
			} else {
				// 跳转用户考试选题界面
				return "3";
			}
		}
		return "1";// 账号密码错误
	}

	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public ModelAndView admin() {
		ModelAndView modelAndView = new ModelAndView();

		modelAndView.setViewName("_admin/index");
		return modelAndView;
	}

}
