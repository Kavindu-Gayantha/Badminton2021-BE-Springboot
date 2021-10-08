package com.example.badminton2021be.badminton_backend_2021.service;

public interface EmailService {
    void sendEmails(String[] to, String topic, String body);

    void sendEmail(String email, String string, String string2);

}
