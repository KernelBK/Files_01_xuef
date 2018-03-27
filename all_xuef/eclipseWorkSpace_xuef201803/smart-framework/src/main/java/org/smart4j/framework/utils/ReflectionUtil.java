package org.smart4j.framework.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * ���乤����
 * @author moveb
 *
 */
public class ReflectionUtil {
	/**
	 * ����ʵ��
	 * @param cls
	 * @return
	 */
	public static Object newInstance(Class<?> cls){
		Object instance = null;
		try{
			instance = cls.newInstance();
		} catch(Exception e){
			e.printStackTrace();
		}
		return instance;
	}
	/**
	 * ���÷���
	 * @param o
	 * @param m
	 * @param args
	 * @return
	 */
	public static Object invokeMethod(Object o, Method m, Object... args){
		Object result = null;
		try{
			m.setAccessible(true);
			result = m.invoke(o, args);
		} catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}
	/**
	 * ���ó�Ա������ֵ
	 * @param o
	 * @param field
	 * @param value
	 */
	public static void setField(Object o, Field field, Object value){
		try{
			field.setAccessible(true);
			field.set(o, value);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
}
