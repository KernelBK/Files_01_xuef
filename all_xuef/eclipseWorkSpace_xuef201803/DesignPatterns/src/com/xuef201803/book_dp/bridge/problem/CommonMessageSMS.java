package com.xuef201803.book_dp.bridge.problem;

/**
 * ��վ�ڶ���Ϣ�ķ�ʽ������ͨ��Ϣ
 * @author moveb
 */
public class CommonMessageSMS implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("��վ�ڶ���Ϣ�ķ�ʽ������ͨ��Ϣ�� " + message + 
				" �� " + toUser);
	}

}
