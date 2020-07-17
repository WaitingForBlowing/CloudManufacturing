package com.lcl.bean;

import java.io.Serializable;

public class Consignee extends User implements Serializable {

    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
