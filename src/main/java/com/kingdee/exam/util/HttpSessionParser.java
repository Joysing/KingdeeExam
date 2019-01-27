package com.kingdee.exam.util;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * HttpSession解析器.
 */
@Component
public class HttpSessionParser {
	/**
	 * HttpSessionParser的构造函数.
	 * @param userService - 自动注入的UserService对象
	 */
	@Autowired
	private HttpSessionParser(UsersService userService) {
		HttpSessionParser.userService = userService;
	}
	
	/**
	 * 获取Session中的用户对象.
	 * @param session - HttpSession对象
	 * @return Session中的用户对象
	 */
	public static User getCurrentUser(HttpSession session) {
		User user = (User) session.getAttribute("myUser");
		return user;
	}
	
	/**
	 * 自动注入的UserService对象.
	 */
	private static UsersService userService;
}
