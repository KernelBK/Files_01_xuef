package org.smart4j.framework.bean;

import java.lang.reflect.Method;

/**
 * ��װAction��Ϣ
 * @author moveb
 *
 */
public class Handler {
	/**
	 * Controller ��
	 */
	private Class<?> controllerClass;
	/**
	 * Action ����
	 */
	private Method actionMethod;
	public Handler(){}
	public Handler(Class<?> controllerClass, Method actionMethod) {
		super();
		this.controllerClass = controllerClass;
		this.actionMethod = actionMethod;
	}
	public Class<?> getControllerClass() {
		return controllerClass;
	}
	public Method getActionMethod() {
		return actionMethod;
	}
}
