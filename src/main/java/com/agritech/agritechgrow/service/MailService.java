package com.agritech.agritechgrow.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.agritech.agritechgrow.entities.MailStructure;

@Service
public class MailService {
    @Autowired
    private JavaMailSender mailSender;

    public boolean sendMail(MailStructure mailStructure){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("saikotti2@gmail.com");
        mailMessage.setText(mailStructure.getMessage());
        mailMessage.setTo(mailStructure.getEmail());

        System.out.println(mailMessage);
        System.out.println(mailSender);
        mailSender.send(mailMessage);
        return true;

    }
}
