package com.xuef201803.book_dp.bridge.problem;

public class UrgencyMessageSMS implements UrgencyMessage {

	@Override
	public void send(String message, String toUser) {
		message = "加急: " + message;
		System.out.println("以邮件的方式发送普通消息: " + message 
				+ " 给 " + toUser);
	}

	@Override
	public Object watch(String messageId) {
		/**
		 * 获取相应数据，组织成监控的数据对象，然后返回
		 */
		return null;
	}

}
