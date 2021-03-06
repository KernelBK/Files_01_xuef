package com.xuef201803.book_dp.bridge.problem;

/**
 * 加急消息的抽象接口
 * @author moveb
 *
 */
public interface UrgencyMessage extends Message {

	/**
	 * 监控某消息的处理过程
	 * @param messageId 被监控消息的编号
	 * @return
	 */
	public Object watch(String messageId);
}
