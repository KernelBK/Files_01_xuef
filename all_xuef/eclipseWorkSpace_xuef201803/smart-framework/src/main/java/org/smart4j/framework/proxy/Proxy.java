package org.smart4j.framework.proxy;

public interface Proxy {
	/**
	 * ִ����ʽ����
	 */
	Object doProxy(ProxyChain proxyChain) throws Throwable;
}
