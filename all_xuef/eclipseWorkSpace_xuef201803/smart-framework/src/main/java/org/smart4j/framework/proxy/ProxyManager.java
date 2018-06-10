package org.smart4j.framework.proxy;

import java.lang.reflect.Method;
import java.util.List;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * ����������(���������)
 * 
 * @author moveb
 *
 */
public class ProxyManager {
	/**
	 * ������������
	 * 
	 * ����һ��Ŀ�����һ��Proxy�ӿ�ʵ�֣����һ����������
	 * 
	 * @param targetClass
	 * @param proxyList
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T createProxy(final Class<?> targetClass,
			final List<Proxy> proxyList){
		return (T)Enhancer.create(targetClass, new MethodInterceptor() {
			
			// ��ʱ�������������? 
			// Ŀ�귽��������ʱ����ת���������󣬵����������???
			@Override
			public Object intercept(Object targetObject, 
									Method targetMethod, 
									Object[] methodParams,
									MethodProxy methodProxy) throws Throwable {
				// ������(��������)�ĵ����߼������� ������
				// ���涯���� �����
				// �ܶ����汻��װ�� ������(ProxyChain)�У�Ȼ�����cglib���ɵĴ���������
				// ������һ�� targetClass ��Ӧһ�� proxy
				return new ProxyChain(targetClass, targetObject, 
									  targetMethod, methodProxy, 
									  methodParams, proxyList)
							.doProxyChain();
			}
		});
	}
}