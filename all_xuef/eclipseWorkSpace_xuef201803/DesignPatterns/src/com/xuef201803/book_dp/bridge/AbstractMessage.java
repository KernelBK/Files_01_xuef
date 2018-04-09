package com.xuef201803.book_dp.bridge;

public abstract class AbstractMessage {
	/**
	 * ����һ��ʵ�ֲ��ֵĶ���
	 */
	protected MessageImplementor messageImpl;

	public AbstractMessage(MessageImplementor messageImpl) {
		this.messageImpl = messageImpl;
	}
	
	/**
	 * ������Ϣ��ת��ʵ�ֲ��ֵķ���
	 * @param message
	 * @param toUser
	 */
	public void sendMessage(String message, String toUser){
		this.messageImpl.send(message, toUser);
	}
}
