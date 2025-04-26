package com.sena.mailsender.DTO;

public class basicMailDTO extends mailDTO {
    private String content;

    public basicMailDTO(String to, String subject, String content) {
        super(to, subject);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
