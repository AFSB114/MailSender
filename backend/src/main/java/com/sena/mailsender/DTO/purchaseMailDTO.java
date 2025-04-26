package com.sena.mailsender.DTO;

public class purchaseMailDTO extends mailDTO{
    private String username;
    private productDTO[] products;
    private Integer totalAmount;

    public purchaseMailDTO(String to, String subject, String username, productDTO[] products, Integer totalAmount) {
        super(to, subject);
        this.username = username;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public productDTO[] getProducts() {
        return products;
    }

    public void setProducts(productDTO[] products) {
        this.products = products;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }
}
