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
import com.kingdee.exam.voj.exception.ResourceNotFoundException;
import com.kingdee.exam.voj.messenger.ApplicationEventListener;
import com.kingdee.exam.voj.model.Submission;
import com.kingdee.exam.voj.service.SubmissionService;
import com.kingdee.exam.voj.util.HttpSessionParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 加载/显示评测的相关信息.
 * 
 * @author Haozhe Xie
 */
@Controller
@RequestMapping(value="/submission")
public class SubmissionController {
	/**
	 * 显示评测列表的页面.
	 * @param problemId - 试题的唯一标识符
	 * @param username - 用户的用户名
	 * @param request - HttpRequest对象
	 * @param response - HttpResponse对象
	 * @return 包含提交列表的ModelAndView对象 
	 */
	@RequestMapping(value="", method=RequestMethod.GET)
	public ModelAndView submissionsView(
            @RequestParam(value="problemId", required=false, defaultValue="0") long problemId,
            @RequestParam(value="username", required=false, defaultValue="") String username,
            HttpServletRequest request, HttpServletResponse response) {
		List<Submission> submissions = submissionService.getSubmissions(problemId, username, NUMBER_OF_SUBMISSION_PER_PAGE);
		return new ModelAndView("submissions/submissions")
					.addObject("submissions", submissions);
	}
	
	/**
	 * 获取历史评测信息的列表.
	 * @param problemId - 试题的唯一标识符
	 * @param username - 用户的用户名
	 * @param startIndex - 当前加载的最后一条记录的提交唯一标识符
	 * @param request - HttpRequest对象
	 * @return 一个包含提交记录列表的HashMap对象
	 */
	@RequestMapping(value="/getSubmissions.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getSubmissionsAction(
			@RequestParam(value="problemId", required=false, defaultValue="0") long problemId,
			@RequestParam(value="username", required=false, defaultValue="") String username,
			@RequestParam(value="startIndex") long startIndex,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>(3, 1);

		List<Submission> submissions = submissionService.getSubmissions(problemId, username, startIndex, NUMBER_OF_SUBMISSION_PER_PAGE);
		result.put("isSuccessful", submissions != null && !submissions.isEmpty());
		result.put("submissions", submissions);
		
		return result;
	}
	
	/**
	 * 获取最新的评测信息的列表.
	 * @param problemId - 试题的唯一标识符
	 * @param username - 用户的用户名
	 * @param startIndex - 当前加载的最新一条记录的提交唯一标识符
	 * @param request - HttpRequest对象
	 * @return 一个包含提交记录列表的HashMap对象
	 */
	@RequestMapping(value="/getLatestSubmissions.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getLatestSubmissionsAction(
			@RequestParam(value="problemId", required=false, defaultValue="0") long problemId,
			@RequestParam(value="username", required=false, defaultValue="") String username,
			@RequestParam(value="startIndex") long startIndex,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>(3, 1);

		List<Submission> submissions = submissionService.getLatestSubmissions(problemId, username, startIndex, NUMBER_OF_SUBMISSION_PER_PAGE);
		result.put("isSuccessful", submissions != null && !submissions.isEmpty());
		result.put("submissions", submissions);
		
		return result;
	}
	
	/**
	 * 显示提交记录详细信息的页面.
	 * @param submissionId - 提交记录的唯一标识符
	 * @param request - HttpRequest对象
	 * @param response - HttpResponse对象
	 * @return 包含提交详细信息的ModelAndView对象 
	 */
	@RequestMapping(value="/{submissionId}", method=RequestMethod.GET)
	@ResponseBody
	public Object submissionView(
            @PathVariable("submissionId") long submissionId,
            HttpServletRequest request, HttpServletResponse response) {
		Submission submission = submissionService.getSubmission(submissionId);
		if ( submission == null ) {
			throw new ResourceNotFoundException();
		}
//		ModelAndView view = new ModelAndView("submissions/submission");
//		view.addObject("submission", submission);
		return submission;
	}
	
	/**
	 * 获取实时的评测结果.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含评测结果信息的StreamingResponseBody对象
	 * @throws IOException 
	 */
	@RequestMapping("/getRealTimeJudgeResult.action")

	public SseEmitter getRealTimeJudgeResultAction(
            @RequestParam(value="submissionId") long submissionId,
            HttpServletRequest request, HttpServletResponse response) throws IOException {
		User currentUser = HttpSessionParser.getCurrentUser(request.getSession());
		Submission submission = submissionService.getSubmission(submissionId);
		
		if ( submission == null ||
				!submission.getUser().equals(currentUser) ||
				!submission.getJudgeResult().getJudgeResultSlug().equals("PD") ) {
			throw new ResourceNotFoundException();
		}
		
		response.addHeader("X-Accel-Buffering", "no");
		SseEmitter sseEmitter = new SseEmitter();
		submissionEventListener.addSseEmitters(submissionId, sseEmitter);
		sseEmitter.send("Established");
		return sseEmitter;
	}
	
	/**
	 * 获取提交记录的详细信息.
	 * @param submissionId - 提交记录的唯一标识符
	 * @param request - HttpRequest对象
	 * @return 包含提交记录详细信息的HashMap对象
	 */
	@RequestMapping(value="/getSubmission.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getSubmissionAction(
			@RequestParam(value="submissionId") long submissionId,
			HttpServletRequest request) {
		Map<String, Object> result = new HashMap<>(3, 1);

		Submission submission = submissionService.getSubmission(submissionId);
		result.put("isSuccessful", submission != null);
		result.put("submission", submission);
		
		return result;
	}
	
	/**
	 * 每次请求所加载评测记录的数量.
	 */
	private static final int NUMBER_OF_SUBMISSION_PER_PAGE = 100;
	
	/**
	 * 自动注入的SubmissionService对象.
	 */
	@Autowired
	private SubmissionService submissionService;
	
	/**
	 * 自动注入的ApplicationEventListener对象.
	 * 用于向其中注册sseEmitter.
	 */
	@Autowired
	private ApplicationEventListener submissionEventListener;
	
	/**
	 * 日志记录器.
	 */
	@SuppressWarnings("unused")
	private static final Logger LOGGER = LogManager.getLogger(SubmissionController.class);
}
