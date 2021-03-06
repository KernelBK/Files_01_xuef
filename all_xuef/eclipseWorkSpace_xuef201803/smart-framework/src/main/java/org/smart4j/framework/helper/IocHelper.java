package org.smart4j.framework.helper;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Inject;
import org.smart4j.framework.utils.ReflectionUtil;

/**
 * 依赖注入 助手类
 * 此时IocHelper 所管理的对象还都是单例的
 * @author moveb
 *
 */
public class IocHelper {
	static{
		System.out.println("IocHelper static code...");
		// 获取所有的 Bean 类与 Bean 实例之间的映射关系（简称 Bean Map）
		Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
		if(!beanMap.isEmpty()){
			// 遍历 Bean Map
			for(Map.Entry<Class<?>, Object> beanEntry:beanMap.entrySet()){
				// 从 BeanMap 中获取Bean类与Bean实例
				Class<?> beanClass = beanEntry.getKey();
				Object beanInstance = beanEntry.getValue();
				// 获取Bean类定义的所有成员变量
				Field[] fields = beanClass.getDeclaredFields();
				if(ArrayUtils.isNotEmpty(fields)){
					// 遍历 fields
					for(Field field:fields){
						// 判定当前Bean Field 是否带有Inject注解
						if(field.isAnnotationPresent(Inject.class)){
							// 在BeanMap 中获取Bean Field对应的实例
							Class<?> beanFieldClass = field.getType();
							Object beanFieldInstance = beanMap.get(beanFieldClass);
							if(beanFieldInstance != null){
								// 通过反射初始化 BeanField 的值
								ReflectionUtil.setField(beanInstance, field, beanFieldInstance);
							}
						}
					}
				}
			}
		}
	}
}
