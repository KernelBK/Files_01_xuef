package org.smart4j.framework.helper;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.smart4j.framework.annotation.Aspect;
import org.smart4j.framework.proxy.AspectProxy;
import org.smart4j.framework.proxy.Proxy;
import org.smart4j.framework.proxy.ProxyManager;

public class AopHelper {

	/**
	 * ��̬���ʼ������AOP���
	 */
	static {
		try{
			// ������ Ŀ���� ӳ��
			Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			// Ŀ�������������֮���ӳ��
			Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
			for(Map.Entry<Class<?>, List<Proxy>> targetEntry:targetMap.entrySet()){
				Class<?> targetClass = targetEntry.getKey();
				// һ��Ŀ��������ж����������
				List<Proxy> proxyList = targetEntry.getValue();
				
				Object proxy = ProxyManager.createProxy(targetClass, proxyList);
				BeanHelper.setBean(targetClass, proxy);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * ��ȡ Aspectע�������õ�ע����
	 * @param aspect
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static Set<Class<?>> createTargetClassSet(Aspect aspect)
		throws Exception{
		Set<Class<?>> targetClassSet = new HashSet<>();
		// Aspectע���value(��Controller)
		Class<? extends Annotation> annotation = aspect.value();
		if(annotation != null && !annotation.equals(Aspect.class)){
			targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
		}
		return targetClassSet;
	}
	
	/**
	 * ��ȡ������(�˴�ָ������)����Ŀ���༯��֮���ӳ���ϵ
	 * ��������Ҫ��չAspectProxy�����࣬����Ҫ����Aspectע�⣬
	 * ֻ���������������������ܸ���Aspectע�����������ע������ȥ��ȡ��ע������Ӧ��Ŀ���༯�ϣ�
	 * Ȼ����ܽ�����������Ŀ���༯��֮���ӳ���ϵ��
	 */
	public static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception{
		Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
		// ��ȡ AspectProxy ��������չ��
		Set<Class<?>> proxyClassSet = ClassHelper.getClassSetBySuper(AspectProxy.class);
		for(Class<?> proxyClass:proxyClassSet){
			if(proxyClass.isAnnotationPresent(Aspect.class)){
				Aspect aspect = proxyClass.getAnnotation(Aspect.class);
				Set<Class<?>> targetClassSet = createTargetClassSet(aspect);
				proxyMap.put(proxyClass, targetClassSet);
			}
		}
		return proxyMap;
	}
	/**
	 * һ����ȡ�˴�������Ŀ���༯��֮���ӳ���ϵ�����ܸ��������ϵ
	 * ������Ŀ��������������б�֮���ӳ���ϵ
	 */
	private static Map<Class<?>, List<Proxy>> createTargetMap(Map<Class<?>, 
			Set<Class<?>>> proxyMap) throws Exception{
		Map<Class<?>, List<Proxy>> targetMap = new HashMap<>();
		for(Map.Entry<Class<?>, Set<Class<?>>> proxyEntry:proxyMap.entrySet()){
			Class<?> proxyClass = proxyEntry.getKey();
			Set<Class<?>> targetClassSet = proxyEntry.getValue();
			
			for(Class<?> targetClass:targetClassSet){
				Proxy proxy = (Proxy)proxyClass.newInstance();
				if(targetMap.containsKey(targetClass)){
					targetMap.get(targetClass).add(proxy);
				}else{
					List<Proxy> proxyList = new ArrayList<Proxy>();
					proxyList.add(proxy);
					// Ŀ���� �� ��������֮���ӳ���ϵ
					targetMap.put(targetClass, proxyList);
				}
			}
		}
		return targetMap;
	}
	
}