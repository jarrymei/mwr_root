package com.silence.controller;

import com.silence.dao.UserMapper;
import com.silence.entity.User;
import com.silence.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
