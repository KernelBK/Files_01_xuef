package com.xuef201803.book_dp.bridge;

/**
 * 特急消息
 * @author moveb
 */
public class SpecialUrgencyMessage extends AbstractMessage {

	public SpecialUrgencyMessage(MessageImplementor messageImpl) {
		super(messageImpl);
	}
	
	public void hurry(String messageId){
		// 执行催促的业务，发出催促的消息
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "特急： " + message;
		super.sendMessage(message, toUser);
	}
}
