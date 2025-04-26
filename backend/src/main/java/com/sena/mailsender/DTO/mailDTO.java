package com.sena.mailsender.DTO;

public abstract class mailDTO {
    private String to;
    private String subject;

    public mailDTO(String to, String subject) {
        this.to = to;
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String username) {
        this.subject = username;
    }
}
