package com.xuef2018.bookstore.service;

import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dao.impl.BookDaoImpl;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.domain.User;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;
import com.xuef2018.bookstore.utils.webutil.WebUtil;

public class BookService {
	private BookDao bd = new BookDaoImpl();
	public Page<Book> getPage(CriteriaBook cb){
		return bd.getPage(cb);
	}
	public Book getBookDetail(int id) {
		return bd.getBook(id);
	}
	public void removeItem(int id) {
	}
}
