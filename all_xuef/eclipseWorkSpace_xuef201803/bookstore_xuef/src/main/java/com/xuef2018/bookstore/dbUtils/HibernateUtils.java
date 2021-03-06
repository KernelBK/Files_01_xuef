package com.xuef2018.bookstore.dbUtils;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	private static SessionFactory sessionFactory;
	// 對應 hibernate 基本配置信息 和 對象關係映射信息
	private static Configuration config = 
			new Configuration().configure();
	private HibernateUtils(){}
	
	public static SessionFactory getInstance(){
		if(sessionFactory == null){
			sessionFactory = config.buildSessionFactory();
		}
		return sessionFactory;
	}
	
	public static Session getSession(){
		return getInstance().openSession();
	}
	public static void releaseSession(Session s){
		s.close();
	}
}
