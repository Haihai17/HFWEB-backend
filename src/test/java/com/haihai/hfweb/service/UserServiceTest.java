package com.haihai.hfweb.service;

import com.haihai.hfweb.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * 用户服务测试
 *
 * @author  haihai
 */
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testAddUser(){
        User user = new User();
        user.setUsername("SUNJIANGHAI");
        user.setUserAccount("123");
        user.setAvatarUrl("https://i2.hdslb.com/bfs/archive/f63a8972b68597efc826916c88641c6a9919ce22.jpg@304w_304h_1c_!web-space-index-myfav.avif");
        user.setGender(0);
        user.setUserPassword("123");
        user.setPhone("123");
        user.setEmail("456");
        boolean result = userService.save(user);
        System.out.println(user.getId());
        Assertions.assertTrue(result);
    }

    @Test
    void userRegister() {
        String userAccount = "asdbv3123s123";
        String userPassword = "12345678";
        String checkPassword = "12345678";
        String planetCode = "1231";
        long result = userService.userRegister(userAccount,userPassword,checkPassword,planetCode);
    }

    @Test
    public void testSearchUsersByTags(){
        List<String> tags = Arrays.asList("青铜");
        List<User> res = userService.searchUserByTags(tags);
    }

}