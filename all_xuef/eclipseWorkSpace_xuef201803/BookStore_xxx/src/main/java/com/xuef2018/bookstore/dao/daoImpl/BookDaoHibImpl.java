package com.xuef2018.bookstore.dao.daoImpl;

import java.util.Collection;
import java.util.List;

import com.xuef2018.bookstore.dao.BaseDao;
import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.web.ShoppingCartItem;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;

public class BookDaoHibImpl extends BaseDao<Book> implements BookDao {

	public Book getBook(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Page<Book> getPage(CriteriaBook cb) {
		// TODO Auto-generated method stub
		return null;
	}

	public long getTotalBookNumber(CriteriaBook cb) {
		// TODO Auto-generated method stub
		return 0;
	}

	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	public int getStoreNumber(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void batchUpdateStoreNumberAndSalesAmount(
			Collection<ShoppingCartItem> items) {
		// TODO Auto-generated method stub
		
	}

}
