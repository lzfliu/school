package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductLoans implements Serializable {
    private Integer id;

    private Integer productId;

    private Integer monthNum;

    private String manageFee;

    private String interest;

    private String rent;

    private Byte formulaId;

    private String baoxianRate;

    private String baoxianbeiRate;

    private Date createdAt;

    private Date updatedAt;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getMonthNum() {
        return monthNum;
    }

    public void setMonthNum(Integer monthNum) {
        this.monthNum = monthNum;
    }

    public String getManageFee() {
        return manageFee;
    }

    public void setManageFee(String manageFee) {
        this.manageFee = manageFee == null ? null : manageFee.trim();
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent == null ? null : rent.trim();
    }

    public Byte getFormulaId() {
        return formulaId;
    }

    public void setFormulaId(Byte formulaId) {
        this.formulaId = formulaId;
    }

    public String getBaoxianRate() {
        return baoxianRate;
    }

    public void setBaoxianRate(String baoxianRate) {
        this.baoxianRate = baoxianRate == null ? null : baoxianRate.trim();
    }

    public String getBaoxianbeiRate() {
        return baoxianbeiRate;
    }

    public void setBaoxianbeiRate(String baoxianbeiRate) {
        this.baoxianbeiRate = baoxianbeiRate == null ? null : baoxianbeiRate.trim();
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
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
        sb.append(", formulaId=").append(formulaId);
        sb.append(", baoxianRate=").append(baoxianRate);
        sb.append(", baoxianbeiRate=").append(baoxianbeiRate);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}