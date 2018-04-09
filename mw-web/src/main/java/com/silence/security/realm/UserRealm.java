package com.silence.security.realm;

import com.silence.commons.Constants;
import com.silence.entity.Function;
import com.silence.entity.Role;
import com.silence.entity.User;
import com.silence.service.IFunctionService;
import com.silence.service.IRoleService;
import com.silence.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by silence on 2018/4/2.
 */
public class UserRealm extends AuthorizingRealm {

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
       /* if (!password.equals(user.getPassword())) {
            throw new IncorrectCredentialsException("用户名/密码错误");
        }*/
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user,
                user.getPassword(),
                ByteSource.Util.bytes(user.getCredentialsSalt()),//username+salt
                this.getName()
        );
        return authenticationInfo;
    }

    @Override
    protected void clearCachedAuthorizationInfo(PrincipalCollection principals) {
        super.clearCachedAuthorizationInfo(principals);
    }

    @Override
    protected void clearCachedAuthenticationInfo(PrincipalCollection principals) {
        super.clearCachedAuthenticationInfo(principals);
    }

    @Override
    protected void clearCache(PrincipalCollection principals) {
        super.clearCache(principals);
    }

    public void clearAllCachedAuthorizationInfo() {
        getAuthorizationCache().clear();
    }

    public void clearAllCachedAuthenticationInfo() {
        getAuthenticationCache().clear();
    }

    /*
     修改权限和角色时需要清空缓存
     */
    public void clearAllCache() {
        clearAllCachedAuthenticationInfo();
        clearAllCachedAuthorizationInfo();
    }

    public static void main(String[] args) {
        System.out.println(ByteSource.Util.bytes("admin" + Constants.USER_SALT));

        SimpleHash simpleHash = new SimpleHash("md5", "123456", ByteSource.Util.bytes("admin" + Constants.USER_SALT), 2);
        System.out.println(simpleHash);
    }
}
