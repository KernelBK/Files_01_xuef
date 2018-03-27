package org.smart4j.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * ���� JSON �� POJO֮���ת��; ���� Jackson ʵ��
 * @author moveb
 *
 */
public class JsonUtil {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	/**
	 * �� POJO תΪ JSON
	 */
	public static <T> String toJson(T obj){
		String json = "";
		try{
			json = OBJECT_MAPPER.writeValueAsString(obj);
		} catch(Exception e){
			e.printStackTrace();
		}
		return json;
	}
	/**
	 * �� JSON תΪ POJO
	 */
	public static <T> T fromJson(String json, Class<T> type){
		T pojo = null;
		try{
			pojo = OBJECT_MAPPER.readValue(json, type);
		} catch(Exception e){
			e.printStackTrace();
		}
		return pojo;
	}
}