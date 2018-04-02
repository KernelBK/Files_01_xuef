package org.smart4j.framework.proxy;

import java.lang.reflect.Method;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.annotation.Controller;

/**
 * ���� controller ���з���
 * @author moveb
 */
@Aspect(Controller.class)
public class ControllerAspect extends AspectProxy {

	private long begin;

	@Override
	public void before(Class<?> clz, Method method, Object[] params)
			throws Throwable {
		// ���������� ��Ҫ��־��¼
		System.out.println("----------begin---------");
		System.out.println(String.format("class: %s", clz.getName()));
		System.out.println(String.format("method: %s", method.getName()));
		begin = System.currentTimeMillis();
	}

	@Override
	public void after(Class<?> clz, Method method, Object[] params,
			Object result) throws Throwable {
		System.out.println(String.format("time: %dms",
									System.currentTimeMillis()));
		System.out.println("----------end---------");
	}
	
}
