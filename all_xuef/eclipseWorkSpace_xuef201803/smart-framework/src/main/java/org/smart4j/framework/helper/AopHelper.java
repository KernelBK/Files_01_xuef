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
	 * 静态块初始化整个AOP框架
	 */
	static {
		try{
			// 代理类 目标类 映射
			Map<Class<?>, Set<Class<?>>> proxyMap = createProxyMap();
			// 目标类与代理对象之间的映射
			Map<Class<?>, List<Proxy>> targetMap = createTargetMap(proxyMap);
			for(Map.Entry<Class<?>, List<Proxy>> targetEntry:targetMap.entrySet()){
				Class<?> targetClass = targetEntry.getKey();
				// 一个目标类可能有多个代理对象
				List<Proxy> proxyList = targetEntry.getValue();
				
				Object proxy = ProxyManager.createProxy(targetClass, proxyList);
				BeanHelper.setBean(targetClass, proxy);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	/**
	 * 获取 Aspect注解中设置的注解类
	 * @param aspect
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unused")
	private static Set<Class<?>> createTargetClassSet(Aspect aspect)
		throws Exception{
		Set<Class<?>> targetClassSet = new HashSet<>();
		// Aspect注解的value(如Controller)
		Class<? extends Annotation> annotation = aspect.value();
		if(annotation != null && !annotation.equals(Aspect.class)){
			targetClassSet.addAll(ClassHelper.getClassSetByAnnotation(annotation));
		}
		return targetClassSet;
	}
	
	/**
	 * 获取代理类(此处指切面类)及其目标类集合之间的映射关系
	 * 代理类需要扩展AspectProxy抽象类，还需要带有Aspect注解，
	 * 只有满足这两个条件，才能根据Aspect注解中所定义的注解属性去获取该注解所对应的目标类集合，
	 * 然后才能建立代理类与目标类集合之间的映射关系。
	 */
	public static Map<Class<?>, Set<Class<?>>> createProxyMap() throws Exception{
		Map<Class<?>, Set<Class<?>>> proxyMap = new HashMap<Class<?>, Set<Class<?>>>();
		// 获取 AspectProxy 的所有扩展类
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
	 * 一旦获取了代理类与目标类集合之间的映射关系，就能根据这个关系
	 * 分析出目标类与代理对象列表之间的映射关系
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
					// 目标类 与 代理对象之间的映射关系
					targetMap.put(targetClass, proxyList);
				}
			}
		}
		return targetMap;
	}
	
}
