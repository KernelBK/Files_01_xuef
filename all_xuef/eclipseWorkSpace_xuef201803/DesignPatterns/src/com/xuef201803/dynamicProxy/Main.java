package com.xuef201803.dynamicProxy;

public class Main {
	public static void main(String[] args) {
		Hello hello = new HelloImpl();
		
		DynamicProxy dp = new DynamicProxy(hello);
		Hello proxy = dp.getProxy();
		proxy.say("Rose");
	}
}