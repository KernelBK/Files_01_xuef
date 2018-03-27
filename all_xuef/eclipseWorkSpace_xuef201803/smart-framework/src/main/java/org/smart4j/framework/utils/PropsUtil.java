package org.smart4j.framework.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropsUtil {
	// �����ļ��������������ļ���
	// ���� properties
	public static Properties loadPro(String fileName){
		InputStream resourceAsStream = PropsUtil.class
				.getClassLoader().getResourceAsStream(fileName);
		System.out.println("fileName: "+fileName);
		Properties properties = new Properties();
		try{
			properties.load(resourceAsStream);
			
		} catch(IOException e){
			e.printStackTrace();
		}
		return properties;
	}
}