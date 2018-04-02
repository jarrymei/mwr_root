package com.silence.service.impl;

import com.silence.dao.base.BaseMapper;
import com.silence.service.IBaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
@Transactional
public class BaseServiceImpl<T, K extends Serializable> implements IBaseService<T, K> {
	
	private BaseMapper<T, K> baseDao;
	
	public void setBaseDao(BaseMapper<T, K> baseDao) {
		this.baseDao = baseDao;
	}

	@Override
	public void save(T entity) {
		baseDao.insert(entity);
	}

	@Override
	public void delete(K id) {
		baseDao.deleteByPrimaryKey(id);
	}

	@Override
	public void update(T entity) {
		baseDao.updateByPrimaryKey(entity);
	}

	@Override
	public T get(K id) {
		return baseDao.selectByPrimaryKey(id);
	}

	@Override
	public List<T> getAll() {
		return baseDao.getAll();
	}

}
