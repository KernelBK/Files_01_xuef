package com.xuef2018.dao;

import java.util.List;

import com.xuef2018.bean.Book;

public interface BookDao {
	// �����û�����ѯ��ӵ�е���
	public List<Book> getAllBooks(String username);
}
