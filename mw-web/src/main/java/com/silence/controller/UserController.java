package com.silence.controller;

import com.github.pagehelper.PageInfo;
import com.silence.dao.UserMapper;
import com.silence.entity.User;
import com.silence.service.IUserService;
import com.silence.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by silence on 2018/4/2.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "{id}", method = RequestMethod.GET, produces = "application/json")
    public User get(@PathVariable("id") Integer id) {
        return userService.get(id);
    }

    //分页的第一种方式
    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public JsonResult info(@RequestParam(required = false, defaultValue = "1") Integer pageNumber,
                           @RequestParam(required = false, defaultValue = "10") Integer pageSize) {
        PageInfo<User> pageInfo = userService.findByPage(pageNumber, pageSize);
        return JsonResult.buildSuccessResult(pageInfo);
    }

    //分页的第二种方式
    @RequestMapping(value = "/info2", method = RequestMethod.GET)
    public JsonResult info2(User user) {

        return null;
    }

}
