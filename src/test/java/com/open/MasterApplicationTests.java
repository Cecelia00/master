package com.open;

import com.open.mapper.UserMapper;
import com.open.pojo.User;
import com.open.service.impl.UserServiceImpl;
import com.open.util.VerCodeGenerateUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class MasterApplicationTests {

    @Autowired
    private UserMapper userMapper;
    private VerCodeGenerateUtil verCodeGenerateUtil;

    @Autowired
    private UserServiceImpl userService;


    @Test
    void contextLoads() {
//        List byID = userMapper.getAll();
//        System.out.println(byID);
//        for (Object o : byID) {
//            System.out.println(o);
//        }
//
//        System.out.println("------------------------");
//        User user = new User();
//        user.setEmail("10086@qq.com");
//        user.setUsername("adeles");
//        user.setPassword("123456");
//        user.setGender(1L);
//
//
//        Integer insert = userMapper.insert(user);
//        System.out.println(insert);
//        System.out.println("------------------------");

//        User email = userMapper.getEmail("10086@qq.com");
//        System.out.println(email);
//        System.out.println("------------------------");
//        System.err.println("UserServiceImpl.reg()");
//
//        // 生成随机验证码的逻辑
//        String code = verCodeGenerateUtil.generateVerCode();
//        System.out.println(code);

//        String email = "10086@qq.com";
//        String oldPassword = "12378.";
//        String newPassword = "123456";

//        User login = userService.login(email, password);
//        System.out.println(login);

//        userService.changePassword(email,oldPassword,newPassword);
//        service.changePassword(email, oldPassword, newPassword);
//        System.err.println("OK.");

        Integer id = 4;
        String avatar = "头像路径";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updateAvatarById(id,avatar,modifiedTime);
        System.err.println("rows=" + rows);



    }

}
