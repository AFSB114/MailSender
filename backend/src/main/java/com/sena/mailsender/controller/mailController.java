package com.sena.mailsender.controller;

import com.sena.mailsender.DTO.basicMailDTO;
import com.sena.mailsender.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/mail")
public class mailController {

    private final mailService mailSender;

    @Autowired
    public mailController(mailService mailSender) {
        this.mailSender = mailSender;
    }

    @PostMapping("/basic")
    public String sendBasicEmail(@RequestBody basicMailDTO mail){
         mailSender.sendBasicMail(mail);
        return "Mail Sent successfully!";
    }

    @GetMapping("/new-account")
    public String sendNewAccountEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }

    @GetMapping("/forgot-pass")
    public String sendForgotPassEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }

    @GetMapping("/active")
    public String sendActiveEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }

    @GetMapping("/changed-pass")
    public String sendChangedPassEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }

    @GetMapping("/low-stock")
    public String sendLowStockEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }

    @GetMapping("/purchase")
    public String sendPurchaseEmail(){
        mailSender.sendMail();
        return "Mail Sent successfully!";
    }
}
