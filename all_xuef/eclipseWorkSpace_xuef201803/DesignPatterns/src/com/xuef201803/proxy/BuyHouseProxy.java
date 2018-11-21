package com.xuef201803.proxy;
/**
 * ������
 * @author moveb
 * 2018.10.25
 * ȱ�㣺���ǵ�Ϊÿһ�����񶼵ô��������࣬������̫�󣬲��׹���
 * ͬʱ�ӿ�һ�������ı䣬������Ҳ����Ӧ�޸ġ�
 */
public class BuyHouseProxy implements BuyHouse {
	BuyHouse buyHouse; // ��������󣬼�ί����
	public BuyHouseProxy(final BuyHouse buyHouse) {
		this.buyHouse = buyHouse;
	}
	@Override
	public void buyHouse() {
		before();
		buyHouse.buyHouse();
		after();
	}

	void before(){
		System.out.println("before...");
	}
	
	void after(){
		System.out.println("after...");
	}
}
