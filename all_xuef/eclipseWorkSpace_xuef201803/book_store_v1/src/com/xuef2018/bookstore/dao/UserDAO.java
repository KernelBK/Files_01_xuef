package com.xuef2018.bookstore.dao;

import com.xuef2018.bookstore.domain.User;

public interface UserDAO {

	/**
	 * �����û�����ȡ User ����
	 * @param username
	 * @return
	 */
	public abstract User getUser(String username);

}

