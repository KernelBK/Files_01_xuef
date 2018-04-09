package com.xuef201803.book_dp.bridge.problem;

/**
 * 以邮件的方式发送普通消息
 * @author moveb
 */
public class CommonMessageEmail implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("以邮件的方式发送普通消息: " + message 
				+ " 给 " + toUser);
	}

}
