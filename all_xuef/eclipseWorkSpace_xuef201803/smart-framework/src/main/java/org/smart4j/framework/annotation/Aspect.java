package org.smart4j.framework.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE) // 加在类上
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	/**
	 * 切面
	 * Class<Integer> cla;与Class<?> cl;
	 * 前一个表示cla只能指向Integer这种类型，而后一个cl表示可以指向任意类型。
	 */
	Class<? extends Annotation> value();
}
