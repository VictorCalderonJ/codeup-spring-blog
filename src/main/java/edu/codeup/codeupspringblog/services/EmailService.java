package edu.codeup.codeupspringblog.services;

import edu.codeup.codeupspringblog.models.Ad;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

    private final JavaMailSender javaMailSender;

    public EmailService(JavaMailSender javaMailSender, JavaMailSender emailSender) {
        this.javaMailSender = javaMailSender;
        this.emailSender = emailSender;
    }

    public final JavaMailSender emailSender;

    @Value("${spring.mail.from}")
    private String from;


    public void prepareAndSend(Ad ad, String subject, String body) {
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(from);
        msg.setTo("user@email.com");
        msg.setSubject(subject);
        msg.setText(body);

        try{
            this.javaMailSender.send(msg);
        }
        catch (MailException ex) {
            // simply log it and go on...
            System.err.println(ex.getMessage());
        }
    }
}

