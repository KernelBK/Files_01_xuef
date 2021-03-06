package com.xuef2018.bookstore.dao.daoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.xuef2018.bookstore.dao.TradeDao;
import com.xuef2018.bookstore.domain.Trade;

public class TradeDaoHibImpl implements TradeDao {
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}
	
	@Override
	public int insertOne(Trade trade) {
		getSession().save(trade);
		System.out.println(trade.getTradeid());
		return trade.getTradeid();
	}

}
