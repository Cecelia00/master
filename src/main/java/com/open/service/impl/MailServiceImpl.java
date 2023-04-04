package com.open.service.impl;

import com.open.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class MailServiceImpl implements MailService {

    @Autowired
   private JavaMailSender mailSender;

    public void sendMail(String email, String verificationCode) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setText("亲爱的小爱同学 正在被接管... 您的验证码是: " + verificationCode);
        message.setSubject("电子黑客局");
        message.setFrom("1264818637@qq.com");

        mailSender.send(message);
    }
}
