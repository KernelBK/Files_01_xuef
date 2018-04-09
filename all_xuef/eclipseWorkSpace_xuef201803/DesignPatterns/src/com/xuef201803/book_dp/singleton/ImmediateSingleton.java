package com.xuef201803.book_dp.singleton;

public class ImmediateSingleton {
	// static ��������װ�ص�ʱ����г�ʼ��
	private static ImmediateSingleton singleton = 
			new ImmediateSingleton();
	
	private ImmediateSingleton(){}
	
	public static ImmediateSingleton getInsance(){
		return singleton;
	}
}
