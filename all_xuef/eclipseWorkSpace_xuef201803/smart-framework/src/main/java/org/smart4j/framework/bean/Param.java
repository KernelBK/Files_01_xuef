package org.smart4j.framework.bean;

import java.util.Map;

/**
 * �����������
 * @author moveb
 *
 */
public class Param {
	private Map<String, Object> paramMap;

	public Param(Map<String, Object> paramMap) {
		this.paramMap = paramMap;
	}
	/**
	 * ���ݲ�������ȡ lonh �Ͳ���ֵ
	 * @param name
	 * @return
	 */
	public long getLong(String name){
		return (long) paramMap.get(name);
	}
	/**
	 * ��ȡ�����ֶ���Ϣ
	 */
	public Map<String, Object> getMap(){
		return paramMap;
	}
}