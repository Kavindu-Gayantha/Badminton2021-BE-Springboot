package com.example.badminton2021be.badminton_backend_2021.service.serviceImpl;

import com.example.badminton2021be.badminton_backend_2021.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

//    static final Logger log =  LoggerFactory.getLogger(GetClassLoader.class);

    final String from = "sltmrms@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Async
    public void sendEmails(String[] to, String topic, String body){
        try {
//            lo/g.info("Mail sending is started");
            System.out.println("Mail sending started");

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(body);
            simpleMailMessage.setText(topic);
            javaMailSender.send(simpleMailMessage);

//            log.info("Mail sending is completed");
            System.out.println("Mail sending completed");


        }catch (Exception e){
//            log.error("Error occured: "+e.getMessage());
            System.out.println(("Error occured: "+e.getMessage()));

        }
    }

    @Async
    public void sendEmail(String to, String topic, String body){
        try {
//            log.info("Mail sending is started");
            System.out.println("Mail sending started");

            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(from);
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(body);
            simpleMailMessage.setText(topic);
            javaMailSender.send(simpleMailMessage);

//            log.info("Mail sending is completed");
            System.out.println("Mail sending completed");


        }catch (Exception e){
//            log.error("Error occured: "+e.getMessage());
            System.out.println(("Error occured: "+e.getMessage()));
        }
    }

}
