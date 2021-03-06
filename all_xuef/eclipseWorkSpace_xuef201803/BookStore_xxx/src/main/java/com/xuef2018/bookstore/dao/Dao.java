package com.xuef2018.bookstore.dao;

import java.util.List;

/**
 * 定义 Dao 通用操作, BaseDao 提供实现
 * @author moveb
 *
 * @param <T>
 */
public interface Dao<T> {
	/**
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 * @return: 插入的新记录的 id
	 */
	public long insert(String sql, Object ... args);
	
	/**
	 * 执行 UPDATE 操作, 包括 INSERT(但没有返回值), UPDATE, DELETE
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 */
	void update(String sql, Object ... args);
	
	/**
	 * 查询单条记录, 返回与记录对应的类的一个对象
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 * @return: 与记录对应的类的一个对象
	 */
	T query(String sql, Object ... args);
	
	/**
	 * 查询多条记录, 返回一个对象的 List
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 * @return: 包含多个对象的一个 List
	 */
	List<T> queryForList(String sql, Object ... args);
	
	/**
	 * 执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 * @return: 执行一个属性或值的查询操作, 例如查询某一条记录的一个字段, 或查询某个统计信息, 返回要查询的值
	 */
	<V> V getSingleVal(String sql, Object ... args);
	
	/**
	 * 执行批量更新操作
	 * @param sql: 待执行的 SQL
	 * @param args: 填充占位符的可变参数
	 */
	void batch(String sql, Object[]... params);
}
