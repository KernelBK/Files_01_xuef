package com.xuef201803.book_dp.simpleFactory;

/**
 * ���ڿͻ�����˵��ֻ�й����ͽӿ��ǿɼ��ġ�
 * @author moveb
 */
public class Client {
	public static void main(String[] args) {
		Api impl = SimpleFac.getInstance(2);
		impl.operate();
	}
}
