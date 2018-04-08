package com.silence.service.impl;

import com.silence.dao.RoleMapper;
import com.silence.entity.Role;
import com.silence.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role, Integer> implements IRoleService {

	@Autowired
	private RoleMapper roleMapper;
	
	@Autowired
	public void setRoleMapper(RoleMapper roleMapper) {
		super.setBaseDao(roleMapper);
	}

	@Override
	public List<Role> findByUserId(Integer userId) {
		return roleMapper.findByUserId(userId);
	}
}
