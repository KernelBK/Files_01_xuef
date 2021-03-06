package com.xuef.architect.customermgr.dao;

import org.springframework.stereotype.Repository;

import com.xuef.architect.common.dao.BaseDAO;
import com.xuef.architect.customermgr.vo.CustomerModel;
import com.xuef.architect.customermgr.vo.CustomerQueryModel;

@Repository("customerDAO")
public interface CustomerDAO extends BaseDAO<CustomerModel, 
									CustomerQueryModel> {
	/**
	 * CRUD 的真正实现是MyBatis来做的
	 */
}
