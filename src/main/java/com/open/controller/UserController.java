package com.open.controller;


import com.open.pojo.User;
import com.open.service.MailService;
import com.open.service.UserService;

import com.open.util.ApiResponse;
import com.open.util.JsonResult;
import com.open.util.VerCodeGenerateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;


    private static final int OK = 2000;

   @PostMapping("/reg")
    public JsonResult<Void> reg(User user) {
        // 调用业务对象执行注册
        userService.addUser(user);
        // 返回成功
        return new JsonResult<>(OK);
    }

    @PostMapping("/send")
    public ResponseEntity<?> sendVerificationCode(@RequestParam String email) {

//        String code = String.format("%06d", random.nextInt(999999));
        VerCodeGenerateUtil verCodeGenerateUtil = new VerCodeGenerateUtil();
        String code = verCodeGenerateUtil.generateVerCode();
        System.out.println(code);
        mailService.sendMail(email,code);
        return ResponseEntity.ok(new ApiResponse(true, "Verification code sent successfully"));
    }

    // http://localhost:8080/users/login?username=digest&password=0000
    @PostMapping("login")
    public JsonResult<User> login(String email, String password, HttpSession session) {
        // 调用userService.login()方法执行登录，并获取返回结果（成功登录的用户数据）
        User data = userService.login(email, password);
        // 将返回结果中的uid和username存入到Session
        session.setAttribute("id", data.getId());
        session.setAttribute("email", data.getEmail());
        // 将结果响应给客户端
        return new JsonResult<>(OK, data);
    }

    @PostMapping("password")
    public JsonResult<Void> changePassword(String email,String oldPassword, String newPassword) {
        // 从Session中取出uid和username
        System.out.println(email+"??????????");
        System.out.println(oldPassword);
        System.out.println(newPassword);
//        Integer uid = Integer.valueOf(session.getAttribute("uid").toString());
//        String username = session.getAttribute("username").toString();
        // 调用userService.changePassword()执行修改密码
        userService.changePassword(email, oldPassword, newPassword);
        // 返回操作成功
        return new JsonResult<>(OK);
    }



}
