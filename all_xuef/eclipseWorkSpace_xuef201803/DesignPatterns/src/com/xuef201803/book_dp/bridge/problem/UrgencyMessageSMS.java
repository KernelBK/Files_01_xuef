package com.xuef201803.book_dp.bridge.problem;

public class UrgencyMessageSMS implements UrgencyMessage {

	@Override
	public void send(String message, String toUser) {
		message = "�Ӽ�: " + message;
		System.out.println("���ʼ��ķ�ʽ������ͨ��Ϣ: " + message 
				+ " �� " + toUser);
	}

	@Override
	public Object watch(String messageId) {
		/**
		 * ��ȡ��Ӧ���ݣ���֯�ɼ�ص����ݶ���Ȼ�󷵻�
		 */
		return null;
	}

}