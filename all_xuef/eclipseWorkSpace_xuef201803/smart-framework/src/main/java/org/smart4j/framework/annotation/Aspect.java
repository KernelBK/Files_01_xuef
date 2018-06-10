package org.smart4j.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // ��������
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * ����
	 * Class<Integer> cla;��Class<?> cl;
	 * ǰһ����ʾclaֻ��ָ��Integer�������ͣ�����һ��cl��ʾ����ָ���������͡�
	 */
	Class<? extends Annotation> value();
}