package com.xuef201803.proxy;

public class Main {
	public static void main(String[] args) {
		BuyHouse buyHouse = new BuyHouseImpl();
        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(buyHouse);
        buyHouseProxy.buyHouse();
	}
}
