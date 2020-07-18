package com.lcl.bean;

import java.io.Serializable;

public class Equipment implements Serializable {

    private int etid;
    private int oid;
    private int fid;
    private int equipmentId;
    private String equipmentName;
    private String equipmentSpecification;
    private String equipmentStatus;
    private String rentalStatus;

    public int getEtid() {
        return etid;
    }

    public void setEtid(int etid) {
        this.etid = etid;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public int getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(int equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentSpecification() {
        return equipmentSpecification;
    }

    public void setEquipmentSpecification(String equipmentSpecification) {
        this.equipmentSpecification = equipmentSpecification;
    }

    public String getEquipmentStatus() {
        return equipmentStatus;
    }

    public void setEquipmentStatus(String equipmentStatus) {
        this.equipmentStatus = equipmentStatus;
    }

    public String getRentalStatus() {
        return rentalStatus;
    }

    public void setRentalStatus(String rentalStatus) {
        this.rentalStatus = rentalStatus;
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "etid=" + etid +
                ", oid=" + oid +
                ", fid=" + fid +
                ", equipmentId=" + equipmentId +
                ", equipmentName='" + equipmentName + '\'' +
                ", equipmentSpecification='" + equipmentSpecification + '\'' +
                ", equipmentStatus='" + equipmentStatus + '\'' +
                ", rentalStatus='" + rentalStatus + '\'' +
                '}';
    }
}
