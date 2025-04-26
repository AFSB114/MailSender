package com.sena.mailsender.service;

import com.sena.mailsender.DTO.*;
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

    public void sendBasicMail(basicMailDTO mail) {  // Nombre de clase DTO con mayúscula inicial
        Context context = new Context();
        context.setVariable("subject", mail.getSubject());
        context.setVariable("content", mail.getContent());

        String html = templateEngine.process("basicMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendNewAccount(newAccountMailDTO mail) {
        Context context = new Context();
        context.setVariable("username", mail.getUsername());

        String html = templateEngine.process("newAccountMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendForgotPass(forgotPassMailDTO mail){
        Context context = new Context();
        context.setVariable("username", mail.getUsername());

        String html = templateEngine.process("forgotPassMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendActiveEmail(activeAccountMailDTO mail){
        Context context = new Context();
        context.setVariable("username", mail.getUsername());

        String html = templateEngine.process("activeAccountMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendChangedPass(changedPassMailDTO mail){
        Context context = new Context();
        context.setVariable("username", mail.getUsername());

        String html = templateEngine.process("changedPassMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendLowStock(lowStockMailDTO mail){
        Context context = new Context();
        context.setVariable("productName", mail.getProductName());
        context.setVariable("currentStock", mail.getCurrentStock());
        context.setVariable("minStock", mail.getMinStock());

        String html = templateEngine.process("lowStockMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    public void sendPurchase(purchaseMailDTO mail){
        Context context = new Context();
        context.setVariable("username", mail.getUsername());
        context.setVariable("productList", mail.getProducts());
        context.setVariable("totalAmount",  mail.getTotalAmount());

        String html = templateEngine.process("purchaseMail", context);

        sendMail(html, mail.getTo(), mail.getSubject());
    }

    private void sendMail(String html, String mailTo, String subject) {
        try{
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "UTF-8");

            helper.setFrom(username);
            helper.setTo(mailTo);
            helper.setSubject(subject);
            helper.setText(html, true);

            javaMailSender.send(message);
        }  catch (Exception e) {
            System.out.println("Error al enviar correo: " + e.getMessage());
        }
    }
}
