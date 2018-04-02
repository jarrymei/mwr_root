package com.silence.service;

import com.silence.entity.Function;

import java.util.List;

public interface IFunctionService extends IBaseService<Function, Integer> {

    List<Function> findByUserId(Integer userId);
}
