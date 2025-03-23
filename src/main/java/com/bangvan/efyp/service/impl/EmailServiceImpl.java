package com.bangvan.efyp.service.impl;

import com.bangvan.efyp.service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {


    private final JavaMailSender mailSender;



    @Override
    public void sendEmail(String email, Integer otp) throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
        mimeMessageHelper.setTo(email);
        mimeMessageHelper.setSubject("Verify your account");
        String emailContent = """
            <html>
                <body style="font-family: Arial, sans-serif; background-color: #f4f4f9; color: #333; line-height: 1.6; padding: 20px;">
                    <div style="max-width: 600px; margin: 0 auto; background: #fff; padding: 20px; border: 1px solid #ddd; border-radius: 5px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);">
                        <div style="text-align: center; margin-bottom: 20px;">
                            <h1 style="color: #4CAF50;">Welcome to Our Website!</h1>
                        </div>
                        <p>Thank you for registering on our website. Please use the OTP below to verify your email address:</p>
                        <div style="font-size: 24px; font-weight: bold; text-align: center; margin: 20px 0; color: #4CAF50;">
                        """
                + otp +
                """
        </div>
                <p>If you didn't request this, please ignore this email.</p>
                <hr>
                <div style="margin-top: 20px; font-size: 12px; text-align: center; color: #777;">
                    <p>&copy; 2025. All rights reserved.</p>
                </div>
            </div>
        </body>
    </html>
    """;

        mimeMessageHelper.setText(emailContent, true);
        mailSender.send(mimeMessage);
    }
}
