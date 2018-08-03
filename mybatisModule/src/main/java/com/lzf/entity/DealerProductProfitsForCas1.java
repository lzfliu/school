package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class DealerProductProfitsForCas1 implements Serializable {
    private String id;
    private Integer dealerId;
    private Integer dealerProductId;
    private Integer business;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
    private Integer disable;
    private String createBy;
    private String updateBy;
    private String onePrice;
    private String oneProfit;
    private String twoPrice;
    private String twoProfit;
    private String threePrice;
    private String threeProfit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDealerId() {
        return dealerId;
    }

    public void setDealerId(Integer dealerId) {
        this.dealerId = dealerId;
    }

    public Integer getDealerProductId() {
        return dealerProductId;
    }

    public void setDealerProductId(Integer dealerProductId) {
        this.dealerProductId = dealerProductId;
    }

    public Integer getBusiness() {
        return business;
    }

    public void setBusiness(Integer business) {
        this.business = business;
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

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Integer getDisable() {
        return disable;
    }

    public void setDisable(Integer disable) {
        this.disable = disable;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public String getOnePrice() {
        return onePrice;
    }

    public void setOnePrice(String onePrice) {
        this.onePrice = onePrice;
    }

    public String getOneProfit() {
        return oneProfit;
    }

    public void setOneProfit(String oneProfit) {
        this.oneProfit = oneProfit;
    }

    public String getTwoPrice() {
        return twoPrice;
    }

    public void setTwoPrice(String twoPrice) {
        this.twoPrice = twoPrice;
    }

    public String getTwoProfit() {
        return twoProfit;
    }

    public void setTwoProfit(String twoProfit) {
        this.twoProfit = twoProfit;
    }

    public String getThreePrice() {
        return threePrice;
    }

    public void setThreePrice(String threePrice) {
        this.threePrice = threePrice;
    }

    public String getThreeProfit() {
        return threeProfit;
    }

    public void setThreeProfit(String threeProfit) {
        this.threeProfit = threeProfit;
    }
}