package com.silence.service.impl;

import com.silence.dao.FunctionMapper;
import com.silence.entity.Function;
import com.silence.service.IFunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FunctionServiceImpl extends BaseServiceImpl<Function, Integer> implements IFunctionService {

	@Autowired
	private FunctionMapper functionMapper;
	
	@Autowired
	public void setFunctionMapper(FunctionMapper functionMapper) {
		super.setBaseDao(functionMapper);
	}

	@Override
	public List<Function> findByUserId(Integer userId) {
		return functionMapper.findFuncByUserId(userId, false, null, null);
	}
}
