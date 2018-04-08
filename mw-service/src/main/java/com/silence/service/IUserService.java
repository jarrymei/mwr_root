package com.silence.service;

import com.github.pagehelper.PageInfo;
import com.silence.entity.User;

import java.util.List;
import java.util.Map;

public interface IUserService extends IBaseService<User, Integer> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByUserName(String username);


    PageInfo<User> findByPage(Integer pageNumber, Integer pageSize);

    List<Map<String, Object>> findUser();
}
