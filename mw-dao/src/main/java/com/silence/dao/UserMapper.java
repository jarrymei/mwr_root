package com.silence.dao;

import com.silence.dao.base.BaseMapper;
import com.silence.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper extends BaseMapper<User, Integer> {

    User findByUserName(String username);
}