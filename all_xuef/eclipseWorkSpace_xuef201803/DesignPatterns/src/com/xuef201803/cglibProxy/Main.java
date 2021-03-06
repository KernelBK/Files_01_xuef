package com.xuef201803.cglibProxy;

import com.xuef201803.dynamicProxy.Hello;
import com.xuef201803.dynamicProxy.HelloImpl;

public class Main {
	public static void main(String[] args) {
		// 根据被代理对象的实现类 类模板 HelloImpl.class
		// cglib 就能为其生成代理对象
		Hello helloProxy = CGLibProxy.getInstance().
										getProxy(HelloImpl.class);
		helloProxy.say("Rose");
	}
}
