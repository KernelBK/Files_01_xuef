package com.xuef.architect.common.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.xuef.architect.common.dao.BaseDAO;

public class BaseService<M, CM> implements IBaseService<M, CM> {
	private BaseDAO baseDAO; // 如何注入?
	/**
	 * baseDAO 的真正实现是谁?
	 */
	public void setBaseDAO(BaseDAO baseDAO) {
		System.out.println("Set baseDAO: " + baseDAO);
		this.baseDAO = baseDAO;
	}
	public void create(M m) {
		baseDAO.create(m);
	}

	public void update(M m) {
		baseDAO.update(m);
	}

	public void delete(Integer id) {
		baseDAO.delete(id);
	}

	public M getByUuid(Integer id) {
		return (M) baseDAO.getByUuid(id);
	}

	public List<M> getByCondition(CM cqm) {
		return baseDAO.getByCondition(cqm);
	}

}
