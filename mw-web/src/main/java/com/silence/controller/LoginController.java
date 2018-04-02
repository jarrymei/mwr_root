package com.silence.controller;

import com.silence.entity.vo.MenuVO;
import com.silence.service.IUserService;
import com.silence.util.JsonResult;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by silence on 2018/4/2.
 */
@RestController
public class LoginController {

    @Autowired
    private IUserService userService;

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public JsonResult login(@RequestParam String username, @RequestParam String password) {
        Subject currentUser = SecurityUtils.getSubject();
        try {
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            currentUser.login(token);
            return JsonResult.buildSuccessResult("登录成功", currentUser.getSession().getId());
        } catch (UnknownAccountException e) {
            return JsonResult.buildFailureResult("用户名/密码错误");
        } catch (IncorrectCredentialsException e) {
            return JsonResult.buildFailureResult("用户名/密码错误");
        }
    }

    @RequestMapping(value = "unauth")
    public JsonResult unauth() {
        return JsonResult.buildFailureResult("未登录");
    }

}
