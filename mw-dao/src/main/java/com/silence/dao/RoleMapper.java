package com.silence.dao;

import com.silence.dao.base.BaseMapper;
import com.silence.entity.Role;

import java.util.List;

public interface RoleMapper extends BaseMapper<Role, Integer> {

    List<Role> findByUserId(Integer userId);

}