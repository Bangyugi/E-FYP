package com.bangvan.efyp.service;

import jakarta.mail.MessagingException;

public interface EmailService {
    void sendEmail(String email, Integer otp) throws MessagingException;
}
