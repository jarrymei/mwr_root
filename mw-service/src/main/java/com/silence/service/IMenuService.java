package com.silence.service;

import com.silence.entity.vo.MenuVO;

import java.util.List;

public interface IMenuService {

	/**
	 * 根据用户id查询用户菜单
	 * @param userId
	 * @return
	 */
	List<MenuVO> getMenuByUserId(Integer userId);
}
