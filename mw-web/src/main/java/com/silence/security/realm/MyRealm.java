package com.silence.security.realm;

import com.silence.entity.Function;
import com.silence.entity.Role;
import com.silence.entity.User;
import com.silence.service.IFunctionService;
import com.silence.service.IRoleService;
import com.silence.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by silence on 2018/4/2.
 */
public class MyRealm extends AuthorizingRealm {

    @Autowired
    private IUserService userService;
    @Autowired
    private IFunctionService functionService;
    @Autowired
    private IRoleService roleService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        User userInfo = (User) principals.getPrimaryPrincipal();
        List<Role> roles = roleService.findByUserId(userInfo.getUserId());
        List<Function> permissions = functionService.findByUserId(userInfo.getUserId());
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : roles) {
            authorizationInfo.addRole(role.getRoleName());
        }
        for (Function function :permissions) {
            authorizationInfo.addStringPermission(function.getFuncUrl());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String) token.getPrincipal();
        String password = String.valueOf((char[]) token.getCredentials());
        User user = userService.findByUserName(username);
        if (user == null) {
            throw new UnknownAccountException("用户名/密码错误");
        }
        if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名/密码错误");
        }
       /* SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getPassword()), this.getName()
        );*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                this.getName()
        );
        return authenticationInfo;
    }
}
