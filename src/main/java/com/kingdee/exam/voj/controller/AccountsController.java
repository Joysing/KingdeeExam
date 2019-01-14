/* Verwandlung Online Judge - A cross-platform judge online system
 * Copyright (C) 2018 Haozhe Xie <cshzxie@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 *
 *                              _ooOoo_  
 *                             o8888888o  
 *                             88" . "88  
 *                             (| -_- |)  
 *                             O\  =  /O  
 *                          ____/`---'\____  
 *                        .'  \\|     |//  `.  
 *                       /  \\|||  :  |||//  \  
 *                      /  _||||| -:- |||||-  \  
 *                      |   | \\\  -  /// |   |  
 *                      | \_|  ''\---/''  |   |  
 *                      \  .-\__  `-`  ___/-. /  
 *                    ___`. .'  /--.--\  `. . __  
 *                 ."" '<  `.___\_<|>_/___.'  >'"".  
 *                | | :  `- \`.;`\ _ /`;.`/ - ` : | |  
 *                \  \ `-.   \_ __\ /__ _/   .-` /  /  
 *           ======`-.____`-.___\_____/___.-`____.-'======  
 *                              `=---=' 
 *
 *                          HERE BE BUDDHA
 *
 */
package com.kingdee.exam.voj.controller;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.service.UsersService;
import com.kingdee.exam.voj.model.Language;
import com.kingdee.exam.voj.service.LanguageService;
import com.kingdee.exam.voj.service.OptionService;
import com.kingdee.exam.voj.service.SubmissionService;
import com.kingdee.exam.voj.util.CsrfProtector;
import com.kingdee.exam.voj.util.DateUtils;
import com.kingdee.exam.voj.util.HttpRequestParser;
import com.kingdee.exam.voj.util.HttpSessionParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 处理用户的登录/注册请求.
 * 
 * @author Haozhe Xie
 */
@Controller
@RequestMapping(value="/accounts")
public class AccountsController {
	/**
	 * 显示用户的登录页面.
	 * @param isLogout - 是否处于登出状态
	 * @param forwardUrl - 登录后跳转的地址(相对路径)
	 * @param request - HttpServletRequest对象
	 * @param response - HttpResponse对象
	 * @return 包含登录页面信息的ModelAndView对象
	 */
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView loginView(
            @RequestParam(value="logout", required=false, defaultValue="false") boolean isLogout,
            @RequestParam(value="forward", required=false, defaultValue="") String forwardUrl,
            HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		if ( isLogout ) {
			destroySession(request, session);
		}
		
		ModelAndView view = null;
		if ( isLoggedIn(session) ) {
			RedirectView redirectView = new RedirectView(request.getContextPath());
			redirectView.setExposeModelAttributes(false);
			view = new ModelAndView(redirectView);
		} else {
			view = new ModelAndView("accounts/login");
			view.addObject("isLogout", isLogout);
			view.addObject("forwardUrl", forwardUrl);
		}
		return view;
	}
	
	/**
	 * 为注销的用户销毁Session.
	 * @param request - HttpServletRequest对象
	 * @param session - HttpSession 对象
	 */
	private void destroySession(HttpServletRequest request, HttpSession session) {
		User currentUser = HttpSessionParser.getCurrentUser(request.getSession());
		String ipAddress = HttpRequestParser.getRemoteAddr(request);
		LOGGER.info(String.format("%s logged out at %s", new Object[] {currentUser, ipAddress}));
		
		session.setAttribute("isLoggedIn", false);
	}
	
	/**
	 * 检查用户是否已经登录.
	 * @param session - HttpSession 对象
	 * @return 用户是否已经登录
	 */
	private boolean isLoggedIn(HttpSession session) {
		Boolean isLoggedIn = (Boolean)session.getAttribute("isLoggedIn");
		if ( isLoggedIn == null || !isLoggedIn.booleanValue() ) {
			return false;
		}
		return true;
	}

	/**
	 * 为登录的用户创建Session.
	 * @param request - HttpServletRequest对象
	 * @param user - 一个User对象, 包含用户的基本信息
	 * @param isAutoLoginAllowed - 是否保存登录状态
	 */
	private void getSession(HttpServletRequest request, User user, boolean isAutoLoginAllowed) {
		HttpSession session = request.getSession();
		session.setAttribute("isLoggedIn", true);
		session.setAttribute("isAutoLoginAllowed", isAutoLoginAllowed);
		session.setAttribute("uid", user.getUserId());
		
		String ipAddress = HttpRequestParser.getRemoteAddr(request);
		LOGGER.info(String.format("%s logged in at %s", new Object[] {user, ipAddress}));
	}
	
	/**
	 * 显示用户注册的页面.
	 * @param request - HttpServletRequest对象
	 * @param response - HttpResponse对象
	 * @return 包含注册页面信息的ModelAndView对象
	 */
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public ModelAndView registerView(
            @RequestParam(value="forward", required=false, defaultValue="") String forwardUrl,
            HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		ModelAndView view = null;
		if ( isLoggedIn(session) ) {
			RedirectView redirectView = new RedirectView(request.getContextPath());
			redirectView.setExposeModelAttributes(false);
			view = new ModelAndView(redirectView);
		} else {
			List<Language> languages = languageService.getAllLanguages();
			boolean isAllowRegister = optionService.getOption("allowUserRegister").getOptionValue().equals("1");
			
			view = new ModelAndView("accounts/register");
			view.addObject("languages", languages);
			view.addObject("isAllowRegister", isAllowRegister);
			view.addObject("csrfToken", CsrfProtector.getCsrfToken(session));
		}
		return view;
	}
	

	/**
	 * 获取某个用户一段时间内的提交次数.
	 * @param userId - 用户的唯一标识符
	 * @param period - 时间间隔的天数
	 * @param request - HttpServletRequest对象
	 * @return 包含某个用户提交次数与时间的 Map 对象
	 */
	@RequestMapping(value="/getNumberOfSubmissionsOfUsers.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getNumberOfSubmissionsOfUsersAction(
			@RequestParam(value="uid", required=false, defaultValue="0") long userId,
			@RequestParam(value="period") int period,
			HttpServletRequest request) {
		if ( userId == 0 ) {
			HttpSession session = request.getSession();
			userId = (Long)session.getAttribute("uid");
		}
		Map<String, Object> submissions = new HashMap<>(2, 1);
		Date today = new Date();
		Date previousDate = DateUtils.getPreviousDate(period);
		Map<String, Long> totalSubmissions = submissionService.getNumberOfSubmissionsUsingDate(previousDate, today, userId, false);
		Map<String, Long> acceptedSubmissions = submissionService.getNumberOfSubmissionsUsingDate(previousDate, today, userId, true);
		
		submissions.put("totalSubmissions", totalSubmissions);
		submissions.put("acceptedSubmissions", acceptedSubmissions);
		return submissions;
	}

	/**
	 * 自动注入的UserService对象.
	 * 用于完成用户业务逻辑操作.
	 */
	@Autowired
	private UsersService userService;
	
	/**
	 * 自动注入的LanguageService对象.
	 * 用于加载注册页面的语言选项.
	 */
	@Autowired
	private LanguageService languageService;
	
	/**
	 * 自动注入的SubmissionService对象.
	 * 用于加载个人信息页面用户的提交和通过情况.
	 */
	@Autowired
	private SubmissionService submissionService;
	
	/**
	 * 自动注入的OptionService对象.
	 * 用于查询注册功能是否开放.
	 */
	@Autowired
	private OptionService optionService;
	
	/**
	 * 日志记录器.
	 */
	private static final Logger LOGGER = LogManager.getLogger(AccountsController.class);
}