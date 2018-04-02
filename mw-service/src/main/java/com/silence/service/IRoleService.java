package com.silence.service;

import com.silence.entity.Role;

import java.util.List;

public interface IRoleService extends IBaseService<Role, Integer> {

    List<Role> findByUserId(Integer userId);
}
