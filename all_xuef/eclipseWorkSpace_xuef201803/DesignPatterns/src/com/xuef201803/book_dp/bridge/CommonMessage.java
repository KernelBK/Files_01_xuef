package com.xuef201803.book_dp.bridge;

public class CommonMessage extends AbstractMessage {

	public CommonMessage(MessageImplementor messageImpl) {
		super(messageImpl);
	}
	
	@Override
	public void sendMessage(String message, String toUser) {
		// ������ͨ��Ϣ��ʲô�����ɣ�ֱ�ӵ��ø���ķ���������Ϣ���ͳ�ȥ�Ϳ�����
		super.sendMessage(message, toUser);
	}
}
