package com.lcl.controller.temp;

import java.io.Serializable;

public class ProductTemp implements Serializable {

    private String productName;
    private String productInfo;
    private String productSpecification;
    private String productType;

    public ProductTemp(String productName, String productInfo, String productSpecification, String productType) {
        this.productName = productName;
        this.productInfo = productInfo;
        this.productSpecification = productSpecification;
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductInfo() {
        return productInfo;
    }

    public void setProductInfo(String productInfo) {
        this.productInfo = productInfo;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}
