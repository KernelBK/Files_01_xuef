package com.xuef2018.bookstore.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.xuef2018.bookstore.dao.BookDao;
import com.xuef2018.bookstore.dao.impl.BookDaoImpl;
import com.xuef2018.bookstore.domain.Book;
import com.xuef2018.bookstore.servlet.CriteriaBook;
import com.xuef2018.bookstore.servlet.Page;

public class TestBookDao {
	private BookDao bd = new BookDaoImpl();
	@Test
	public void testGetBook() {
		Book book = bd.getBook(1);
		System.out.println("book: " + book);
	}
	@Test
	public void testGetTotalBookNumber() {
		System.out.println(bd.getTotalBookNumber(new 
				CriteriaBook(0, 900, 1)));
	}
	
	@Test
	public void testGetPage() {
		Page<Book> page = bd.getPage(new CriteriaBook(0, 900, 80));
		System.out.println(page.getList());
		System.out.println(page.getPageNo());
	}
}
