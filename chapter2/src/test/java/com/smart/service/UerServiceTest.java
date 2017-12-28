package com.smart.service;


import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.Test;


import java.util.Date;

import static org.testng.Assert.*;

@ContextConfiguration("classpath*:/smart-context.xml")
public class UerServiceTest extends AbstractTransactionalTestNGSpringContextTests {

    @Autowired
    private UserService userService;

    @Test
    public void testHasMatchUser(){
        boolean b1 = userService.hasMatchUser("admin", "123456");
        boolean b2 = userService.hasMatchUser("admin", "123");
        assertTrue(b1);
        assertTrue(!b2);
    }

    @Test
    public void testFindUserByUserName(){
        for (int i = 0; i < 100; i++) {
            User user = userService.findUserByUserName("admin");
            assertEquals(user.getUserName(),"adin");
        }
    }
    @Test
    public void testAddLoginLog(){
        User user = userService.findUserByUserName("admin");
        user.setUserId(1);
        user.setUserName("admin");
        user.setLastIp("192.168.1.1");
        user.setLastVisist(new Date());
        userService.loginSuccess(user);
    }
}
