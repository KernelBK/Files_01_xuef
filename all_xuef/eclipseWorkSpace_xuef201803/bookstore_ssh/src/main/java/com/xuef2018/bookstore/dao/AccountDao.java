package com.xuef2018.bookstore.dao;

public interface AccountDao {
	/**
	 * 更新账户余额(扣除)
	 */
	public void updateBalance(int accountid, float amount);
}
