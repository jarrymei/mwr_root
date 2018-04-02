package com.silence.service;

import com.silence.entity.User;
import com.silence.util.PageHandler;

public interface IUserService extends IBaseService<User, Integer> {

    /**
     * 根据用户名查询用户
     * @param username
     * @return
     */
    User findByUserName(String username);

}
