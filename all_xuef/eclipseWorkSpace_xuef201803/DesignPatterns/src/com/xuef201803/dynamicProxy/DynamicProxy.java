package com.xuef201803.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理
 * 在动态代理中我们不再需要再手动的创建代理类，我们只需要编写一个动态处理器就可以了。
 * 真正的代理对象由JDK在运行时为我们动态的来创建。
 * ; 缺点: 无法代理没有任何接口的类
 * @author moveb
 *
 */
public class DynamicProxy implements InvocationHandler {

	private Object target; // 被代理对象
	public DynamicProxy(Object target){
		this.target = target;
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		before();
		Object result = method.invoke(target, args);
		after();
		return result;
	}
	/**
	 * 返回代理类实例
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T> T getProxy(){
		return (T) Proxy.newProxyInstance(target.getClass().getClassLoader(), 
				target.getClass().getInterfaces(), // 必须是被代理对象的所有接口
				this);
	}
	public void before(){
		System.out.println("before...");
	}
	
	public void after(){
		System.out.println("after...");
	}
}
