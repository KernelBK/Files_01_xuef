package org.smart4j.framework.helper;

import java.util.HashSet;
import java.util.Set;

import org.smart4j.framework.annotation.Controller;
import org.smart4j.framework.annotation.Service;
import org.smart4j.framework.utils.ClassUtil;
import org.smart4j.framework.utils.ConfigHelper;
/**
 * ��ȡ�����ص���;
 * @author moveb
 *
 */
public class ClassHelper {
	/**
	 * �����༯�ϣ����ڴ�������ص��ࣩ
	 */
	private static final Set<Class<?>> CLASS_SET;
	static{
		String basePackage = ConfigHelper.getAppBasePackage();
		System.out.println("basePackage: " + basePackage);
		CLASS_SET = ClassUtil.getClassSet(basePackage);
	}
	/**
	 * ��ȡӦ�ð��µ�������
	 * @return
	 */
	public static Set<Class<?>> getClassSet(){
		return CLASS_SET;
	}
	/**
	 * ��ȡ���µ�����Service��
	 * @return
	 */
	public static Set<Class<?>> getServiceClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Service.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	public static Set<Class<?>> getControllerClassSet(){
		Set<Class<?>> classSet = new HashSet<Class<?>>();
		for(Class<?> cls:CLASS_SET){
			if(cls.isAnnotationPresent(Controller.class)){
				classSet.add(cls);
			}
		}
		return classSet;
	}
	/**
	 * ��ȡӦ�ð���������Bean�ࣨ������ Service, Controller��
	 * @return
	 */
	public static Set<Class<?>> getBeanClassSet(){
		Set<Class<?>> beanClassSet = new HashSet<Class<?>>();
		beanClassSet.addAll(getServiceClassSet());
		beanClassSet.addAll(getControllerClassSet());
		return beanClassSet;
	}
}