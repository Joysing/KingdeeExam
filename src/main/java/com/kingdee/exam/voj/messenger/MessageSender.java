package com.kingdee.exam.voj.messenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 消息发送服务.
 * 用于发送新的评测任务至消息队列.
 */
@Component
public class MessageSender {
	/**
	 * 用于发送消息至消息队列.
	 */
	@Autowired
	private JmsTemplate jmsTemplate;

	private static final Logger LOGGER = LogManager.getLogger(MessageSender.class);
	/**
	 * 发送消息至消息队列.
	 * @param mapMessage - Key-Value格式的消息
	 */
	public void sendMessage(final Map<String, Object> mapMessage) {
		long submissionId = (Long) mapMessage.get("submissionId");
		
		jmsTemplate.convertAndSend(mapMessage);
		LOGGER.info(String.format("Submission 任务 #%d 已创建.", submissionId));
	}
}
