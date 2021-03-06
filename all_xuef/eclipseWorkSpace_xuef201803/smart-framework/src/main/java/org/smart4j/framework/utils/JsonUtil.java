package org.smart4j.framework.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 处理 JSON 与 POJO之间的转换; 基于 Jackson 实现
 * @author moveb
 *
 */
public class JsonUtil {
	private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
	/**
	 * 将 POJO 转为 JSON
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
	 * 将 JSON 转为 POJO
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
