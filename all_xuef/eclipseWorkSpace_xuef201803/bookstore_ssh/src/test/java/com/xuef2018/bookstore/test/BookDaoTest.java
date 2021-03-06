package com.xuef2018.bookstore.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dao.daoImpl.BookDaoHibImpl;
import com.xuef2018.bookstore.dao.daoImpl.BookDaoImpl;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.servlet.CriteriaBook;

public class BookDaoTest {
	private BookDao bookDao = new BookDaoImpl();
	private BookDao bookDaoHib = new BookDaoHibImpl();
	@Test
	public void testGetBook() {
		Book book = bookDao.getBook(1);
		System.out.println(book);
	}
	@Before
	public void init(){
		
	}
	@After
	public void destroy(){
		
	}
	@Test
	public void testGetBookOfHib() {
		Book book = bookDaoHib.getBook(1);
		System.out.println(book);
	}
	@Test
	public void testGetBookNum() {
		long bookNumber = bookDaoHib.
				getTotalBookNumber(new CriteriaBook(0, 0, 9));
		System.out.println(bookNumber);
	}
}
