package org.smart4j.framework.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 流操作工具类
 * @author moveb
 *
 */
public class StreamUtil {
	/**
	 * 从输入流中获取字符串
	 */
	public static String getString(InputStream is){
		StringBuilder sb = new StringBuilder();
		try{
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			String line = "";
			while((line = reader.readLine()) != null){
				sb.append(line);
			}
		} catch(Exception e){
			e.printStackTrace();
		}
		return sb.toString();
	}
}
