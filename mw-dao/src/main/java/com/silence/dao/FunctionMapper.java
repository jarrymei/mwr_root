package com.silence.dao;

import com.silence.dao.base.BaseMapper;
import com.silence.entity.Function;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FunctionMapper extends BaseMapper<Function, Integer> {

    /**
     * 根据用户id查询父权限
     * @param userId
     * @return
     */
    List<Function> findFuncByUserId(@Param("userId") Integer userId,
                                    @Param("isParent") Boolean isParent,
                                    @Param("parentId") Integer parentId,
                                    @Param("funcType") Integer funcType);

    /**
     * 根据用户id查询子权限
     * @param userId
     * @param parentId
     * @return
     */
    /*List<Function> findFuncByUserId(@Param("userId") Integer userId,
                                        @Param("parentId") Integer parentId);*/




}