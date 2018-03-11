package com.xuef2018.dao;

import java.util.List;

import com.xuef2018.bean.Book;

public interface BookDao {
	// 根据用户名查询其拥有的书
	public List<Book> getAllBooks(String username);
}
