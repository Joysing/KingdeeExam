package com.kingdee.exam.controller.voj;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.util.HttpSessionParser;
import com.kingdee.exam.voj.exception.ResourceNotFoundException;
import com.kingdee.exam.voj.messenger.ApplicationEventListener;
import com.kingdee.exam.voj.model.Submission;
import com.kingdee.exam.voj.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 加载/显示评测的相关信息.
 */
@Controller
@RequestMapping(value="/submission")
public class SubmissionController {
    @Autowired
    public SubmissionController(SubmissionService submissionService, ApplicationEventListener submissionEventListener) {
        this.submissionService = submissionService;
        this.submissionEventListener = submissionEventListener;
    }

	/**
	 * 显示提交记录详细信息的页面.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含提交详细信息的ModelAndView对象
	 */
	@RequestMapping(value="/{submissionId}", method=RequestMethod.GET)
	@ResponseBody
	public Object submissionView(
            @PathVariable("submissionId") long submissionId) {
		Submission submission = submissionService.getSubmission(submissionId);
		if ( submission == null ) {
			throw new ResourceNotFoundException();
		}
		return submission;
	}
	
	/**
	 * 获取实时的评测结果.
	 * @param submissionId - 提交记录的唯一标识符
	 * @return 包含评测结果信息的StreamingResponseBody对象
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
	 * @return 包含提交记录详细信息的HashMap对象
	 */
	@RequestMapping(value="/getSubmission.action", method=RequestMethod.GET)
	public @ResponseBody
    Map<String, Object> getSubmissionAction(
            @RequestParam(value = "submissionId") long submissionId) {
		Map<String, Object> result = new HashMap<>(3, 1);

		Submission submission = submissionService.getSubmission(submissionId);
		result.put("isSuccessful", submission != null);
		result.put("submission", submission);

		return result;
	}
	
	private final SubmissionService submissionService;
	
	private final ApplicationEventListener submissionEventListener;
}
