package com.xuef2018.bookstore.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dao.daoImpl.BookDaoHibImpl;
import com.xuef2018.bookstore.dao.daoImpl.BookDaoImpl;
import com.xuef2018.bookstore.domain.Book;

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
}
