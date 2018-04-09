package com.xuef201803.book_dp.bridge;

public class Client {
	public static void main(String[] args) {
//		MessageImplementor messageImpl = new MessageSMS();
		MessageImplementor messageImpl = new MessageEmail();
		
//		AbstractMessage message = new CommonMessage(messageImpl);
		AbstractMessage message = new UrgencyMessage(messageImpl);
		message.sendMessage("���յ̻غ�", "xuef");
	}
}
