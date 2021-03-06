package org.smart4j.framework;

import org.smart4j.framework.helper.AopHelper;
import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.utils.ClassUtil;

/**
 * 加载相应的 Helper 类 
 * @author moveb
 *
 */
public class HelperLoader {
	public static void init(){
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				AopHelper.class,
				IocHelper.class, // 类被加载时，其静态代码块就会被执行; 切只被执行一次;
				ControllerHelper.class
		};
		for(Class<?> cls:classList){
			// 加载所有需要被加载的类
			ClassUtil.loadClass(cls.getName(), true);
		}
	}
}
