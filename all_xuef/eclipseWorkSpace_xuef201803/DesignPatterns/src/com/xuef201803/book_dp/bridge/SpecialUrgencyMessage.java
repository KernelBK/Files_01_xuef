package com.xuef201803.book_dp.bridge;

/**
 * �ؼ���Ϣ
 * @author moveb
 */
public class SpecialUrgencyMessage extends AbstractMessage {

	public SpecialUrgencyMessage(MessageImplementor messageImpl) {
		super(messageImpl);
	}
	
	public void hurry(String messageId){
		// ִ�дߴٵ�ҵ�񣬷����ߴٵ���Ϣ
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "�ؼ��� " + message;
		super.sendMessage(message, toUser);
	}
}