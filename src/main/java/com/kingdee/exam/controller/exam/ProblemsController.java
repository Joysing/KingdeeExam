package com.kingdee.exam.controller.exam;

import com.kingdee.exam.entity.User;
import com.kingdee.exam.util.HttpRequestParser;
import com.kingdee.exam.util.HttpSessionParser;
import com.kingdee.exam.voj.service.SubmissionService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * 处理用户的查看试题/提交评测等请求.
 */
@Controller
@RequestMapping(value="/p")
public class ProblemsController {
    @Autowired
    public ProblemsController(SubmissionService submissionService) {
        this.submissionService = submissionService;
    }

	/**
	 * 创建提交.
	 * @param problemId - 试题的唯一标识符
	 * @param languageSlug - 编程语言的别名
	 * @param code - 代码
	 * @param request - HttpRequest对象
	 * @return 一个包含提交记录创建结果的Map<String, Object>对象
	 */
	@PostMapping("/createSubmission.action")
	public @ResponseBody
    Map<String, Object> createSubmissionAction(
			@RequestParam(value="problemId") long problemId,
			@RequestParam(value="languageSlug") String languageSlug,
			@RequestParam(value="code") String code,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		String ipAddress = HttpRequestParser.getRemoteAddr(request);
		User currentUser = HttpSessionParser.getCurrentUser(session);

		Map<String, Object> result = submissionService.createSubmission(currentUser, problemId, languageSlug, code);
		boolean isSuccessful = (Boolean)result.get("isSuccessful");
		if ( isSuccessful ) {
			long submissionId = (Long)result.get("submissionId");
			LOGGER.info(String.format("User: {%s} submitted code with SubmissionId #%s at %s",
					currentUser, submissionId, ipAddress));
		}
		return result;
	}
	
	private final SubmissionService submissionService;

	private static final Logger LOGGER = LogManager.getLogger(ProblemsController.class);
}
