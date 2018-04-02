package org.smart4j.framework.proxy;

import java.lang.reflect.Method;
/**
 * �������
 * @author moveb
 *
 */
public abstract class AspectProxy implements Proxy {
	
	@Override
	public Object doProxy(ProxyChain proxyChain) throws Throwable {
		Object result = null;
		
		// Ŀ����
		Class<?> cls = proxyChain.getTargetClass();
		// Ŀ�귽��
		Method method = proxyChain.getTargetMethod();
		// ��������
		Object[] params = proxyChain.getMethodParams();
		
		begin();
		
		// ʵ�ֵ��ÿ��
		try{
			if(intercept(cls, method, params)){
				// ����ִ�� ÿ��before
				before(cls, method, params);
				
				// ������ ʹ��һ��Ŀ��������ж�����棨������󣩣���ǿ�˿�ܵĹ���
				result = proxyChain.doProxyChain();
				
				// ����ִ�� ÿ��after
				after(cls, method, params, result);
			}else{
				result = proxyChain.doProxyChain();
			}
		} catch(Exception e){
			throw e;
		} finally{
			end();
		}
		return result;
	}
	public void begin(){
		
	}
	
	public boolean intercept(Class<?> clz, Method method, 
			Object[] params) throws Throwable{
		return true;
	}
	public void before(Class<?> clz, Method method, 
			Object[] params) throws Throwable{
		
	}
	
	public void after(Class<?> clz, Method method, 
			Object[] params, Object result) throws Throwable{
		
	}
	public void error(Class<?> clz, Method method, 
			Object[] params) throws Throwable{
		
	}
	public void end(){
		
	}
}
