package com.kingdee.exam.voj.messenger;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

import java.util.Date;

/**
 * 评测机心跳事件消息.
 */
@Getter
public class KeepAliveEvent extends ApplicationEvent {
	public KeepAliveEvent(Object source, String judgerUsername, String judgerDescription, Date heartbeatTime) {
		super(source);
		this.judgerUsername = judgerUsername;
		this.judgerDescription = judgerDescription;
		this.heartbeatTime = heartbeatTime;
	}

	/**
	 * 评测机的用户名.
	 */
	private final String judgerUsername;
	
	/**
	 * 评测机的描述信息.
	 */
	private final String judgerDescription;
	
	/**
	 * 评测机心跳的时间.
	 */
	private final Date heartbeatTime;
	
}
