package com.silence.controller;

import com.silence.entity.vo.MenuVO;
import com.silence.service.IMenuService;
import com.silence.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lx on 2018/4/2.
 */
@RestController
@RequestMapping("menu")
public class MenuController {

    @Autowired
    private IMenuService menuService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public JsonResult menu(@PathVariable("id") Integer id) {
        List<MenuVO> menuVO = menuService.getMenuByUserId(id);
        return JsonResult.buildSuccessResult(menuVO);
    }
}
