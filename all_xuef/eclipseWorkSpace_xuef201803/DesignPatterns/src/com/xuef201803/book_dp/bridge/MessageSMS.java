package com.xuef201803.book_dp.bridge;

/**
 * ��վ�ڶ���Ϣ�ķ�ʽ������Ϣ
 * @author moveb
 *
 */
public class MessageSMS implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("��վ�ڶ���Ϣ�ķ�ʽ������Ϣ�� " + message + 
				" �� " + toUser);
	}

}