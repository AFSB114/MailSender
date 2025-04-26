package com.sena.mailsender.DTO;

public class lowStockMailDTO extends mailDTO{
    private String productName;
    private Integer currentStock;
    private Integer minStock;

    public lowStockMailDTO(String to, String subject, String productName, Integer currentStock, Integer minStock) {
        super(to, subject);
        this.productName = productName;
        this.currentStock = currentStock;
        this.minStock = minStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getCurrentStock() {
        return currentStock;
    }

    public void setCurrentStock(Integer currentStock) {
        this.currentStock = currentStock;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }
}
