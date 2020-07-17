package com.lcl.bean;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderId;
    private int pid;
    private int productAmount;
    private Date accomplishDeadline;
    private Date tenderDeadline;
    private int consigneeId;
    private String orderStatus;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(int productAmount) {
        this.productAmount = productAmount;
    }

    public Date getAccomplishDeadline() {
        return accomplishDeadline;
    }

    public void setAccomplishDeadline(Date accomplishDeadline) {
        this.accomplishDeadline = accomplishDeadline;
    }

    public Date getTenderDeadline() {
        return tenderDeadline;
    }

    public void setTenderDeadline(Date tenderDeadline) {
        this.tenderDeadline = tenderDeadline;
    }

    public int getConsigneeId() {
        return consigneeId;
    }

    public void setConsigneeId(int consigneeId) {
        this.consigneeId = consigneeId;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
}
