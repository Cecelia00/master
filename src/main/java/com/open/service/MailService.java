package com.open.service;

import org.springframework.stereotype.Service;


@Service
public interface MailService {


    public void sendMail(String email, String verificationCode);

}
