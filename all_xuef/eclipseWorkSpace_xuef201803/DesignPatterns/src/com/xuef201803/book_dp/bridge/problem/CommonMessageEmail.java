package com.xuef201803.book_dp.bridge.problem;

/**
 * ���ʼ��ķ�ʽ������ͨ��Ϣ
 * @author moveb
 */
public class CommonMessageEmail implements Message {

	@Override
	public void send(String message, String toUser) {
		System.out.println("���ʼ��ķ�ʽ������ͨ��Ϣ: " + message 
				+ " �� " + toUser);
	}

}