package org.smart4j.framework.utils;

import java.net.URLDecoder;
import java.net.URLEncoder;
/**
 * ������������������
 * @author moveb
 *
 */
public class CodecUtil {
	/**
	 * �� URL ����
	 */
	public static String encodeURL(String source){
		String target = "";
		try{
			target = URLEncoder.encode(source, "UTF-8");
		} catch(Exception e){
			e.printStackTrace();
		}
		return target;
	}
	/**
	 * �� URL ����
	 */
	public static String decodeURL(String source){
		String target = "";
		try{
			target = URLDecoder.decode(source, "UTF-8");
		} catch(Exception e){
			e.printStackTrace();
		}
		return target;
	}
}