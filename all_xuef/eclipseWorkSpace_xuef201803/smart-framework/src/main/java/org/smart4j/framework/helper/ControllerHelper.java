package org.smart4j.framework.helper;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.smart4j.framework.annotation.Action;
import org.smart4j.framework.bean.Handler;
import org.smart4j.framework.bean.Request;

/**
 * ������������
 * @author moveb
 *
 */
public class ControllerHelper {
	/**
	 * ���ڴ�������봦������ӳ���ϵ����� Action Map��
	 */
	private static final Map<Request, Handler> ACTION_MAP = 
			new HashMap<Request, Handler>();
	static{
		// ��ȡ���е� Controller ��
		Set<Class<?>> controllerClassSet = ClassHelper.getControllerClassSet();
		if(CollectionUtils.isNotEmpty(controllerClassSet)){
			// ������Щ Controller ��
			for(Class<?> controllerClass:controllerClassSet){
				// ��ȡ Controller ���ж���ķ���
				Method[] methods = controllerClass.getDeclaredMethods();
				if(ArrayUtils.isNotEmpty(methods)){
					for(Method m:methods){
						// �жϵ�ǰ�����Ƿ����Actionע��
						if(m.isAnnotationPresent(Action.class)){
							// �� Action ע���л�ȡ URL ӳ�����
							Action action = m.getAnnotation(Action.class);
							String mapping = action.value();
							// ��֤ URL ӳ�����
							if(mapping.matches("\\w+:/\\w*")){
								String[] array = mapping.split(":");
								if(ArrayUtils.isNotEmpty(array) &&
										array.length == 2){
									// ��ȡ���󷽷�������·��
									String requestMethod = array[0];
									String requestPath = array[1];
									System.out.println(requestMethod+":"+requestPath + "--"
											+ controllerClass.getName()+":"+m.getName());
									Request request = new Request(requestMethod, requestPath);
									Handler handler= new Handler(controllerClass, m);
									// ��ʼ�� Action Map
									ACTION_MAP.put(request, handler);
								}
							}
						}
					}
				}
				
			}
		}
	}
	public static Handler getHandler(String requestMethod, String requestPath){
		Request request = new Request(requestMethod, requestPath);
		return ACTION_MAP.get(request);
	}
}