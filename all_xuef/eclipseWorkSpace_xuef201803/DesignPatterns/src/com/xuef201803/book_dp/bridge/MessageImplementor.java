package com.xuef201803.book_dp.bridge;
/**
 * ������Ϣ��ͳһ�ӿ�
 * @author moveb
 *
 */
public interface MessageImplementor {
	/**
	 * ������Ϣ
	 * @param message
	 * @param toUser
	 */
	public void send(String message, String toUser);
}