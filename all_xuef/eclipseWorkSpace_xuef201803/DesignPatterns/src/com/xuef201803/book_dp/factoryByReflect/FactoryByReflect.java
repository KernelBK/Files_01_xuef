package com.xuef201803.book_dp.factoryByReflect;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.xuef201803.book_dp.simpleFactory.Api;

/**
 * ���� + �����ļ�
 * ��˵��������ܱȽϵ� 
 * @author moveb
 */
public class FactoryByReflect {
	public static Api getInstance(){
		Properties properties = new Properties();
		InputStream in = null;
		try{
			// ���������ļ�
			/**
			 * classpath�µ������ļ�;
			 * ��Ŀ���Ҽ�properties�����ѡ��Java buildpath���ұ�source�¿��Կ���
			 * source folder on build path
			 * ����ֻ��src�ڡ����������ļ��������src�¡���Ȼ��Ҳ����add folder
			 */
			in = FactoryByReflect.class.getClassLoader()
								  .getResourceAsStream("factory.properties");
			properties.load(in);
		} catch(IOException e){
			e.printStackTrace();
			System.out.println("װ�������ļ�����...");
		} finally{
			try {
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		Api api = null;
		// �������
		String className = properties.getProperty("impleClass");
		try {
			// ���÷���������ʵ��
			api = (Api) Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return api;
	}
}