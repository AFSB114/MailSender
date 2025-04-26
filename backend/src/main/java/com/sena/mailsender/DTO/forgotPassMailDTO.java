package com.sena.mailsender.DTO;

public class forgotPassMailDTO extends mailDTO {
    private String username;

    public forgotPassMailDTO(String to, String subject, String username) {
        super(to, subject);
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
