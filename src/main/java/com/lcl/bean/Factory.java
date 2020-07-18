package com.lcl.bean;

import java.io.Serializable;

public class Factory implements Serializable {

    private int uid;
    private int factoryId;
    private String factoryName;
    private String factoryInfo;
    private String factoryStatus;

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getFactoryId() {
        return factoryId;
    }

    public void setFactoryId(int factoryId) {
        this.factoryId = factoryId;
    }

    public String getFactoryName() {
        return factoryName;
    }

    public void setFactoryName(String factoryName) {
        this.factoryName = factoryName;
    }

    public String getFactoryInfo() {
        return factoryInfo;
    }

    public void setFactoryInfo(String factoryInfo) {
        this.factoryInfo = factoryInfo;
    }

    public String getFactoryStatus() {
        return factoryStatus;
    }

    public void setFactoryStatus(String factoryStatus) {
        this.factoryStatus = factoryStatus;
    }

    @Override
    public String toString() {
        return "Factory{" +
                "uid=" + uid +
                ", factoryId=" + factoryId +
                ", factoryName='" + factoryName + '\'' +
                ", factoryInfo='" + factoryInfo + '\'' +
                ", factoryStatus='" + factoryStatus + '\'' +
                '}';
    }
}
