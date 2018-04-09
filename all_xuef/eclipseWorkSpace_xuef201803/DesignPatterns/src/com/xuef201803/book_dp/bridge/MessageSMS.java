package com.xuef201803.book_dp.bridge;

/**
 * 以站内短消息的方式发送消息
 * @author moveb
 *
 */
public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("以站内短消息的方式发送消息： " + message + 
				" 给 " + toUser);
	}

}
