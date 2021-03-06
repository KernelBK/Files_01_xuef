package org.smart4j.framework.utils;

import java.util.Properties;

import org.smart4j.framework.ConfigConstant;

/**
 * 读取配置文件; 加载各配置项
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
	 * 获取基础包名
	 * @return
	 */
	public static String getAppBasePackage(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_BASE_PACKAGE);
	}
	/**
	 * 获取jsp路径
	 * @return
	 */
	public static String getJspPath(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_JSP_PATH);
	}
	/**
	 * 获取静态资源路径
	 * @return
	 */
	public static String getAppAssetPath(){
		return CONFIG_PROS.getProperty(ConfigConstant.APP_ASSET_PATH);
	}
}
