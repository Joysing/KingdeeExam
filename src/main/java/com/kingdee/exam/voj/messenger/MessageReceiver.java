package com.kingdee.exam.voj.messenger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import java.util.Calendar;
import java.util.Date;

/**
 * 消息接收服务.
 * 用于接收来自评测机的实时评测结果.
 */
@Component
public class MessageReceiver implements MessageListener {

    private final ApplicationEventPublisher eventPublisher;

	private static final Logger LOGGER = LogManager.getLogger(MessageReceiver.class);

    @Autowired
    public MessageReceiver(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    public void onMessage(Message message) {
		if ( message instanceof MapMessage ) {
			final MapMessage mapMessage = (MapMessage) message;
			
			try {
				String event = mapMessage.getString("event");
				
				if ( "ErrorOccurred".equals(event) ) {
					errorHandler(mapMessage);
				} else if ( "CompileFinished".equals(event) ) {
					compileFinishedHandler(mapMessage);
				} else if ( "TestPointFinished".equals(event) ) {
					testPointFinishedHandler(mapMessage);
				} else if ( "AllTestPointsFinished".equals(event) ) {
					allTestPointsFinishedHandler(mapMessage);
				} else if ( "KeepAlive".equals(event) ) {
					receiveFromAliveJudgersHandler(mapMessage);
				} else {
					LOGGER.warn(String.format("接收到未知事件. [Event = %s]",
                            event));
				}
			} catch (JMSException ex) {
				LOGGER.catching(ex);
			}
		}
	}
	
	/**
	 * 处理评测机发生内部错误的消息.
	 * @param mapMessage - 消息队列中收到的MapMessage对象
	 */
	private void errorHandler(MapMessage mapMessage) throws JMSException {
		long submissionId = mapMessage.getLong("submissionId");
		eventPublisher.publishEvent(new SubmissionEvent(this, submissionId, "System Error", "System Error.", true));
		LOGGER.info(String.format("Submission #%d 返回结果 [System Error].", submissionId));
	}
	
	/**
	 * 处理评测机编译完成时的消息.
	 * @param mapMessage - 消息队列中收到的MapMessage对象
	 */
	private void compileFinishedHandler(MapMessage mapMessage) throws JMSException {
		long submissionId = mapMessage.getLong("submissionId");
		boolean isSuccessful = mapMessage.getBoolean("isSuccessful");
		String log = mapMessage.getString("log");
		if ( isSuccessful ) {
			String message = "代码编译成功。开始测试数据。\n\n";
			eventPublisher.publishEvent(new SubmissionEvent(this, submissionId, "Running", message, false));
			LOGGER.info(String.format("Submission #%d 返回结果 [Compile Successfully].", submissionId));
		} else {
			eventPublisher.publishEvent(new SubmissionEvent(this, submissionId, "Compiler Error", log, true));
			LOGGER.info(String.format("Submission #%d 返回结果 [Compile Error].\n\tError Message:%s",
                    submissionId, log));
		}
	}
	
	/**
	 * 处理评测机完成单个测试点的消息.
	 * @param mapMessage - 消息队列中收到的MapMessage对象
	 */
	private void testPointFinishedHandler(MapMessage mapMessage) throws JMSException {
		long submissionId = mapMessage.getLong("submissionId");
		int checkpointId = mapMessage.getInt("checkpointId");
		String runtimeResult = mapMessage.getString("runtimeResult");
		int usedTime = mapMessage.getInt("usedTime");
		int usedMemory = mapMessage.getInt("usedMemory");
		int score = mapMessage.getInt("score");
		
		String message = String.format("\n- 样例 #%d: %s, 时间 = %d ms, 内存 = %d KB, 分数 = %d\n",
                checkpointId, runtimeResult, usedTime, usedMemory, score);
		eventPublisher.publishEvent(new SubmissionEvent(this, submissionId, "Running", message, false));
		
		LOGGER.info(String.format("Submission #%d/ 测试用例#%d 返回结果 [%s] (所用时间 = %dms, 所用内存 = %d KB, 分数 = %d).",
                submissionId, checkpointId, runtimeResult, usedTime, usedMemory, score));
	}
	
	/**
	 * 处理评测机完成全部测试点的消息.
	 * @param mapMessage - 消息队列中收到的MapMessage对象
	 */
	private void allTestPointsFinishedHandler(MapMessage mapMessage) throws JMSException {
		long submissionId = mapMessage.getLong("submissionId");
		String runtimeResult = mapMessage.getString("runtimeResult");
		int usedTime = mapMessage.getInt("totalTime");
		int usedMemory = mapMessage.getInt("maxMemory");
		int score = mapMessage.getInt("totalScore");
		
		String message = String.format("\n%s, 时间 = %d ms, 内存 = %d KB, 通过率 %d%s\n",
                runtimeResult, usedTime, usedMemory, score,"%");
		eventPublisher.publishEvent(new SubmissionEvent(this, submissionId, runtimeResult, message, true));
		
		LOGGER.info(String.format("Submission #%d 判题完成，返回结果为 [%s] (所用时间 = %d ms, 所用内存 = %d KB, 分数 = %d).",
                submissionId, runtimeResult, usedTime, usedMemory, score));
	}
	
	/**
	 * 处理来自评测机的Keep-Alive消息.
	 * 用于在Web端获取后端评测机的信息.
	 * @param mapMessage - 消息队列中收到的MapMessage对象
	 */
	private void receiveFromAliveJudgersHandler(MapMessage mapMessage) throws JMSException {
		String judgerUsername = mapMessage.getString("username");
		String judgerDescription = mapMessage.getString("description");
		long heartbeatTimeInMillis = mapMessage.getLong("heartbeatTime");
		
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(heartbeatTimeInMillis);
		Date heartbeatTime = calendar.getTime();
		eventPublisher.publishEvent(new KeepAliveEvent(this, judgerUsername, judgerDescription, heartbeatTime));
		LOGGER.info(String.format("接收到来自编译机[%s]的心跳", judgerUsername));
	}
	

}
