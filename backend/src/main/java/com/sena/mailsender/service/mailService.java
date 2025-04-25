package com.sena.mailsender.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class mailService {

    @Value("${spring.mail.username}")
    private String username;

    private final JavaMailSender javaMailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public mailService(JavaMailSender javaMailSender,  TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }

    public void sendBasicMail(String to, String subject, String content) {
        Context context = new Context();
        context.setVariable("subject", subject);
        context.setVariable("content", content);

        String html = templateEngine.process("basicMail", context);

        try {
            mailSender(to, subject, html);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    public void mailSender(String to, String subject, String content) throws MessagingException {
        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setFrom(username);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(content,  true);
            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
