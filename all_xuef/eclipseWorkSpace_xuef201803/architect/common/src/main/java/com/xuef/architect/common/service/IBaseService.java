package com.xuef.architect.common.service;

import java.util.List;

public interface IBaseService<M,CM> {
	public void create(M m);
	public void update(M m);
	public void delete(Integer id);
		
	/**
	 * 根据 id 查询
	 */
	public M getByUuid(Integer id);
	/**
	 * 根据条件查询
	 * @param cqm
	 * @return
	 */
	public List<M> getByCondition(CM cqm);
}
