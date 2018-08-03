package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ProductLoan implements Serializable ,Cloneable{
    private String id;

    private String productId;

    private String monthNum;

    private BigDecimal manageFee;

    private BigDecimal interest;

    private BigDecimal rent;

    private Boolean monthStatus;

    private BigDecimal insuranceRate;

    private BigDecimal insuranceMultiRate;

    private Date createdOn;

    private String createdBy;

    private Byte isDelete;

    private Byte isAvailable;

    private String manageFeeType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(String monthNum) {
        this.monthNum = monthNum == null ? null : monthNum.trim();
    }

    public BigDecimal getManageFee() {
        return manageFee;
    }

    public void setManageFee(BigDecimal manageFee) {
        this.manageFee = manageFee;
    }

    public BigDecimal getInterest() {
        return interest;
    }

    public void setInterest(BigDecimal interest) {
        this.interest = interest;
    }

    public BigDecimal getRent() {
        return rent;
    }

    public void setRent(BigDecimal rent) {
        this.rent = rent;
    }

    public Boolean getMonthStatus() {
        return monthStatus;
    }

    public void setMonthStatus(Boolean monthStatus) {
        this.monthStatus = monthStatus;
    }

    public BigDecimal getInsuranceRate() {
        return insuranceRate;
    }

    public void setInsuranceRate(BigDecimal insuranceRate) {
        this.insuranceRate = insuranceRate;
    }

    public BigDecimal getInsuranceMultiRate() {
        return insuranceMultiRate;
    }

    public void setInsuranceMultiRate(BigDecimal insuranceMultiRate) {
        this.insuranceMultiRate = insuranceMultiRate;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    public Byte getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Byte isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getManageFeeType() {
        return manageFeeType;
    }

    public void setManageFeeType(String manageFeeType) {
        this.manageFeeType = manageFeeType == null ? null : manageFeeType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", monthNum=").append(monthNum);
        sb.append(", manageFee=").append(manageFee);
        sb.append(", interest=").append(interest);
        sb.append(", rent=").append(rent);
        sb.append(", monthStatus=").append(monthStatus);
        sb.append(", insuranceRate=").append(insuranceRate);
        sb.append(", insuranceMultiRate=").append(insuranceMultiRate);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", manageFeeType=").append(manageFeeType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public ProductLoan clone() throws CloneNotSupportedException {
        return (ProductLoan) super.clone();
    }
}