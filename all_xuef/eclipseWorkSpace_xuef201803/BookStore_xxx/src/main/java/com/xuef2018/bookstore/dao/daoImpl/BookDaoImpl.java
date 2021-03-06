package com.xuef2018.bookstore.dao.daoImpl;

import java.util.Collection;
import java.util.List;

import com.xuef2018.bookstore.dao.BaseDao;
import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.web.ShoppingCartItem;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;


public class BookDaoImpl extends BaseDao<Book> implements BookDao {

	public Book getBook(int id) {
		// sql 嵌在java代码中，不好。mybatis 解决这个问题
		String sql = "select id, author, title, price, publishingdate,"
				+ " salesamount, storenumber from mybooks "
				+ "where id = ?";
		Book book = query(sql, id);
		return book;
	}

	public Page<Book> getPage(CriteriaBook cb) {
		Page page = new Page(cb.getPageNo());
		page.setTotalItemNumber((int)getTotalBookNumber(cb));
		cb.setPageNo(page.getPageNo());
		System.out.println(cb);
		page.setList(getPageList(cb, 3));
		return page;
	}

	public long getTotalBookNumber(CriteriaBook cb) {
		String sql = "select count(id) from mybooks "
				+ " where price > ? and price < ?";
		long singleVal = getSingleVal(sql, cb.getMinPrice(), cb.getMaxPrice());
		return singleVal;
	}

	public List<Book> getPageList(CriteriaBook cb, int pageSize) {
		String sql = "select id, author, title, price, publishingdate,"
				+ " salesamount, storenumber from mybooks "
				+ " where price > ? and price < ? "
				+ " limit ?, ?";
		return queryForList(sql, cb.getMinPrice(), cb.getMaxPrice()
				, (cb.getPageNo()-1)*pageSize, pageSize);
	}

	public int getStoreNumber(Integer id) {
		String sql = "select storenumber from mybooks where id = ?";
		return getSingleVal(sql, id);
	}

	public void batchUpdateStoreNumberAndSalesAmount(
			Collection<ShoppingCartItem> items) {
		
	}
}
