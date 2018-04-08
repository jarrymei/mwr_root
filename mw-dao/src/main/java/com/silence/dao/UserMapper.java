package com.silence.dao;

import com.silence.dao.base.BaseMapper;
import com.silence.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface UserMapper extends BaseMapper<User, Integer> {

    User findByUserName(String username);

    List<User> findByPage();

    List<Map<String, Object>> findUser();
}