package com.xuef201803.book_dp.bridge.problem;

/**
 * 消息的统一接口
 * @author moveb
 */
public interface Message {
	/**
	 * 发送消息
	 * @param message 要发送的消息
	 * @param toUser 发送目的者
	 */
	public void send(String message, String toUser);
}
