package com.sena.mailsender.controller;

import com.sena.mailsender.DTO.*;
import com.sena.mailsender.service.mailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mail")
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

    @PostMapping("/new-account")
    public String sendNewAccountEmail(@RequestBody newAccountMailDTO mail){
        mailSender.sendNewAccount(mail);
        return "Mail Sent successfully!";
    }

    @PostMapping("/forgot-pass")
    public String sendForgotPassEmail(@RequestBody forgotPassMailDTO mail){
        mailSender.sendForgotPass(mail);
        return "Mail Sent successfully!";
    }

    @PostMapping("/active-account")
    public String sendActiveEmail(@RequestBody activeAccountMailDTO mail){
        mailSender.sendActiveEmail(mail);
        return "Mail Sent successfully!";
    }

    @PostMapping("/changed-pass")
    public String sendChangedPassEmail(@RequestBody changedPassMailDTO mail){
        mailSender.sendChangedPass(mail);
        return "Mail Sent successfully!";
    }

    @PostMapping("/low-stock")
    public String sendLowStockEmail(@RequestBody lowStockMailDTO mail){
        mailSender.sendLowStock(mail);
        return "Mail Sent successfully!";
    }

    @PostMapping("/purchase")
    public String sendPurchaseEmail(@RequestBody purchaseMailDTO mail){
        mailSender.sendPurchase(mail);
        return "Mail Sent successfully!";
    }
}
