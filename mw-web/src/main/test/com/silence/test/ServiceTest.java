package com.silence.test;

import com.github.pagehelper.PageInfo;
import com.silence.entity.User;
import com.silence.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

/**
 * Created by silence on 2018/4/2.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class ServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void testQuery() {
        List<User> users = userService.getAll();
        System.out.println(users);
    }

    @Test
    public void testSave() {
        User user = new User();
        user.setUserName("李硕");
        user.setPassword("333333");
        userService.save(user);
    }

    @Test
    public void testSqlInterceptor() {
       PageInfo<User> list = userService.findByPage(1, 10);
    }

    @Test
    public void testResultForMap() {
        List<Map<String, Object>> map = userService.findUser();
        System.out.println(map);
    }
}
