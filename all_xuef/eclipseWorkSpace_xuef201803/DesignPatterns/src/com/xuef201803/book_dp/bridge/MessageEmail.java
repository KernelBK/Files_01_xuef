package com.xuef201803.book_dp.bridge;

/**
 * ���ʼ��ķ�ʽ������ͨ��Ϣ
 * @author moveb
 *
 */
public class MessageEmail implements MessageImplementor {

	@Override
	public void send(String message, String toUser) {
		System.out.println("���ʼ��ķ�ʽ������Ϣ: " + message 
				+ " �� " + toUser);
	}

}