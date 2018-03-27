package org.smart4j.framework.utils;

import java.util.Properties;

import org.smart4j.framework.ConfigConstant;

/**
 * ��ȡ�����ļ�; ���ظ�������
 * @author moveb
 *
 */
public class ConfigHelper {
	private static Properties CONFIG_PROS = 
				PropsUtil.loadPro(ConfigConstant.CONFIG_FILE);
	
	public static String getJdbcDriver(){
		return CONFIG_PROS.getProperty(ConfigConstant.JDBC_DRIVER);
	}
	public static String getJdbcUrl(){
		return CONFIG_PROS.getProperty(ConfigConstant.JDBC_URL);
	}
	public static String getUserName(){
		return CONFIG_PROS.getProperty(ConfigConstant.JDBC_USERNAME);
	}
	public static String getPwd(){
		return CONFIG_PROS.getProperty(ConfigConstant.JDBC_PASSWORD);
	}
	/**
	 * ��ȡ��������
	 * @return
	 */
	public static String getAppBasePackage(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_BASE_PACKAGE);
	}
	/**
	 * ��ȡjsp·��
	 * @return
	 */
	public static String getJspPath(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_JSP_PATH);
	}
	/**
	 * ��ȡ��̬��Դ·��
	 * @return
	 */
	public static String getAppAssetPath(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_ASSET_PATH);
	}
}
