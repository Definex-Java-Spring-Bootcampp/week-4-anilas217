package com.patika.kredinbizdenservice.Service;

import com.patika.kredinbizdenservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;



@Service
public class EmailService {

    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("your-email@gmail.com");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

    public void sendTestEmail(User user) {
        String to = "anilarslan1997@gmail.com";
        String subject = "Test Email";
        String text = "This is a test email.";

        sendSimpleMessage(to, subject, text);
    }
}
