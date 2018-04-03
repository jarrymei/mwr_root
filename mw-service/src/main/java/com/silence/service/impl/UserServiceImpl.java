package com.silence.service.impl;

import com.silence.dao.UserMapper;
import com.silence.entity.User;
import com.silence.service.IUserService;
import com.silence.util.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
}
