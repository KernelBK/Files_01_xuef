package com.xuef2018.bookstore.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.xuef2018.bookstore.db.JDBCUtils;
import com.xuef2018.bookstore.domain.Book;

/**
 * ͨ�ò�ѯ
 * @author moveb
 *
 */
public class XuefBaseDao {
	@Test
	public void testGet(){
		String sql = "select id, author, title from mybooks"
				+ " where id = ?";
		Book b = get(Book.class, sql, 1);
		System.out.println(b);
	}
	
	public <T> T get(Class<T> clazz, String sql, Object... args){
		T entity = null;
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		ResultSet rs = null;
		
		try {
			conn = JDBCUtils.getConnection();
			preparedStatement = conn.prepareStatement(sql);
			for(int i=0; i<args.length; i++){
				preparedStatement.setObject(i+1, args[i]);
			}
			rs = preparedStatement.executeQuery();
			// ���ResultSetMetaData����
			ResultSetMetaData resultSetMetaData = rs.getMetaData();
			// ����ѯ����� ��װ��map��
			Map<String, Object> values = new HashMap<>();
			while(rs.next()){
				for(int i=1; i<=resultSetMetaData.getColumnCount(); i++){
					// ��ȡ�б���
					String columnLabel = resultSetMetaData.getColumnLabel(i);
					Object columnVal = rs.getObject(columnLabel);
					values.put(columnLabel, columnVal);
				}
				// �������󲢸�ֵ
				entity = clazz.newInstance();
				for(Map.Entry<String, Object> entry:values.entrySet()){
					String fieldName = entry.getKey();
					Object val = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, val);
				}
			}
			
		} catch (SQLException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}
}