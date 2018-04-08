package com.silence.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.silence.dao.UserMapper;
import com.silence.entity.User;
import com.silence.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl extends BaseServiceImpl<User, Integer> implements IUserService {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	public void setUserMapper(UserMapper userMapper) {
		super.setBaseDao(userMapper);
	}

	@Override
	public User findByUserName(String username) {
		return userMapper.findByUserName(username);
	}

	@Override
	public PageInfo<User> findByPage(Integer pageNumber, Integer pageSize) {
		PageHelper.startPage(pageNumber, pageSize);
		List<User> users = userMapper.getAll();
		PageInfo<User> pageInfo = new PageInfo<User>(users);
		return pageInfo;
	}

	@Override
	public List<Map<String, Object>> findUser() {
		return userMapper.findUser();
	}
}
