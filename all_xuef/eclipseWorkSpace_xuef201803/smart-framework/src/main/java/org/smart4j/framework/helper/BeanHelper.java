package org.smart4j.framework.helper;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.smart4j.framework.utils.ReflectionUtil;

/**
 * 相当于一个 Bean 容器
 * @author moveb
 *
 */
public class BeanHelper {
	/**
	 * 定义 Bean 映射（用于存放 Bean 类与 Bean 实例的映射关系）
	 */
	private static final Map<Class<?>, Object> BEAN_MAP=
			new HashMap<Class<?>, Object>();
	static{
		Set<Class<?>> beanClassSet = ClassHelper.getBeanClassSet();
		for(Class<?> beanClass:beanClassSet){
			Object object = ReflectionUtil.newInstance(beanClass);
			BEAN_MAP.put(beanClass, object);
		}
	}
	/**
	 * 获取 Bean 映射
	 * @return
	 */
	public static Map<Class<?>, Object> getBeanMap(){
		return BEAN_MAP;
	}
	/**
	 * 获取 Bean 实例
	 * @param cls
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T getBean(Class<T> cls){
		if(!BEAN_MAP.containsKey(cls)){
			throw new RuntimeException("can not get bean by class: "+cls);
		}
		return (T) BEAN_MAP.get(cls);
	}
	
	public static void setBean(Class<?> cls, Object obj) {
		BEAN_MAP.put(cls, obj);
	}
}
