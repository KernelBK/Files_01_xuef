package org.smart4j.framework;

import org.smart4j.framework.helper.BeanHelper;
import org.smart4j.framework.helper.ClassHelper;
import org.smart4j.framework.helper.ControllerHelper;
import org.smart4j.framework.helper.IocHelper;
import org.smart4j.framework.utils.ClassUtil;

/**
 * ������Ӧ�� Helper �� 
 * @author moveb
 *
 */
public class HelperLoader {
	public static void init(){
		Class<?>[] classList = {
				ClassHelper.class,
				BeanHelper.class,
				IocHelper.class, // �౻����ʱ���侲̬�����ͻᱻִ��; ��ֻ��ִ��һ��;
				ControllerHelper.class
		};
		for(Class<?> cls:classList){
			// ����������Ҫ�����ص���
			ClassUtil.loadClass(cls.getName(), true);
		}
	}
}