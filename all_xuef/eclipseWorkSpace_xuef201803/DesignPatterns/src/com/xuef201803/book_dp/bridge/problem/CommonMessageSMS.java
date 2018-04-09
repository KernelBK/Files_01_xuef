package com.xuef201803.book_dp.bridge.problem;

/**
 * 以站内短消息的方式发送普通消息
 * @author moveb
 */
public class CommonMessageSMS implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("以站内短消息的方式发送普通消息： " + message + 
				" 给 " + toUser);
	}

}
