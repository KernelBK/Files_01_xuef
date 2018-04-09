package com.xuef201803.book_dp.bridge.abstract_desc;
/**
 * ���󲿷ֵĽӿ�
 * @author moveb
 *
 */
public abstract class Abstraction {
	/**
	 * ����һ��ʵ�ֲ��ֵĶ���
	 */
	protected Implementor impl;
	
	public Abstraction(Implementor impl) {
		this.impl = impl;
	}
	
	/**
	 * ʾ��������ʵ��һ���Ĺ��ܣ�������Ҫת��ʵ�ֲ��ֵľ���ʵ�ַ���
	 */
	public void operation(){
		impl.operationImpl();
	}
}
