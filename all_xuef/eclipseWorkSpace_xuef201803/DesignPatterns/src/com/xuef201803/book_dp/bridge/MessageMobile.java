package com.xuef201803.book_dp.bridge;

public class MessageMobile implements MessageImplementor {
	@Override
	public void send(String message, String toUser) {
		System.out.println("���ֻ�����Ϣ�ķ�ʽ������Ϣ�� " + message + 
				" �� " + toUser);
	}
}
