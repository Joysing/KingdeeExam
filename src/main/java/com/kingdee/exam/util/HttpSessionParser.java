package com.kingdee.exam.util;

import com.kingdee.exam.entity.User;
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
     */
	@Autowired
	private HttpSessionParser() {
    }
	
	/**
	 * 获取Session中的用户对象.
	 * @param session - HttpSession对象
	 * @return Session中的用户对象
	 */
	public static User getCurrentUser(HttpSession session) {
        return (User) session.getAttribute("myUser");
	}

}
