package com.xuef201803.book_dp.bridge;

/**
 * 以邮件的方式发送普通消息
 * @author moveb
 *
 */
public class MessageEmail implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("以邮件的方式发送消息: " + message 
				+ " 给 " + toUser);
	}

}
