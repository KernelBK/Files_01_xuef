package com.xuef2018.bookstore.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import com.xuef2018.bookstore.dao.AccountDao;
import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dao.TradeDao;
import com.xuef2018.bookstore.dao.TradeItemDao;
import com.xuef2018.bookstore.dao.UserDao;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.Trade;
import com.xuef2018.bookstore.domain.TradeItem;
import com.xuef2018.bookstore.domain.User;
import com.xuef2018.bookstore.domain.web.ShoppingCart;
import com.xuef2018.bookstore.domain.web.ShoppingCartItem;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;

public class BookService {
	private BookDao bookDao;
	private UserDao userDao;
	private AccountDao accountDao;
	private TradeDao tradeDao;
	private TradeItemDao tradeItemDao;
	
	public void setTradeDao(TradeDao tradeDao) {
		this.tradeDao = tradeDao;
	}
	public void setTradeItemDao(TradeItemDao tradeItemDao) {
		this.tradeItemDao = tradeItemDao;
	}
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	public void setBookDao(BookDao bookDao) {
		this.bookDao = bookDao;
	}
	public List<Book> getAllBooks(){
		return bookDao.getAllBooks();
	}
	public Book getBook(int id) {
		return bookDao.getBook(id);
	}
	public Page<Book> getPage(CriteriaBook criteriaBook) {
		return bookDao.getPage(criteriaBook);
	}
	/**
	 * 用户名是否存在 
	 */
	public boolean existName(String username) {
		User user = userDao.getUser(username);
		if(user != null) return true;
		return false;
	}
	/**
	 * 检验用户名密码是否匹配
	 */
	public boolean checkPwd(String username, String pwd) {
		User user = userDao.getUser(username);
		if(Integer.parseInt(pwd) == user.getAccountid()) return true;
		return false;
	}
	public void pay(String username, ShoppingCart cart) {
		User user = userDao.getUser(username);
		int userid = user.getId();
		int accountid = user.getAccountid();
		System.out.println("******** "+userid + "---"+accountid);
		// 1. 更新库存： 销量和存货 mybooks
		bookDao.batchUpdateStoreNumberAndSalesAmount(cart.getItems());
		System.out.println("cart.getItems() "+cart.getItems());
		// 2. 更新账户余额 account
		accountDao.updateBalance(accountid, cart.getTotalMoney());
		System.out.println("cart.getTotalMoney() "+cart.getTotalMoney());
		// 3. 插入一条 trade 记录
		Trade trade = new Trade();
		trade.setUserid(userid);
		trade.setTradetime(new Date());
		int tradeid = tradeDao.insertOne(trade);
		System.out.println("---------"+cart.getTotalMoney());
		// 4. 插入若干条 tradeitem
		Collection<TradeItem> items = new ArrayList();
		for(ShoppingCartItem sci:cart.getItems()){
			TradeItem ti = new TradeItem();
			ti.setBookid(sci.getBook().getId());
			ti.setQuantity(sci.getBookNum());
			ti.setTradeid(tradeid);
			items.add(ti);
		}
		tradeItemDao.insertAny(items);
		// 5. 清空购物车		
	}
}
