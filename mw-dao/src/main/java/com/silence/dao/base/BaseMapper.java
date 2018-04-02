package com.silence.dao.base;

import com.silence.entity.Function;

import java.io.Serializable;
import java.util.List;

/**
 * Created by 梅佳杰 on 2018/4/2.
 */
public interface BaseMapper<T, PK extends Serializable> {

    int deleteByPrimaryKey(PK id);

    int insert(T record);

    int insertSelective(T record);

    T selectByPrimaryKey(PK id);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKey(T record);

    List<T> getAll();
}
