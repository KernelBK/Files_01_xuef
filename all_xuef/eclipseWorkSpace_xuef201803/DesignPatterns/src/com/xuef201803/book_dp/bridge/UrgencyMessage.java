package com.xuef201803.book_dp.bridge;

public class UrgencyMessage extends AbstractMessage {

	public UrgencyMessage(MessageImplementor messageImpl) {
		super(messageImpl);
	}

	@Override
	public void sendMessage(String message, String toUser) {
		message = "�Ӽ��� " + message;
		super.sendMessage(message, toUser);
	}
	/**
	 * ��չ�Լ����¹��ܣ����ĳ��Ϣ�Ĵ������
	 * @param messageId
	 * @return
	 */
	public Object watch(String messageId){
		//
		return null;
	}
}
