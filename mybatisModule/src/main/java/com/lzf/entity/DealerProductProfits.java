package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class DealerProductProfits implements Serializable {
    private String id;

    private String companyId;

    private String loanPeriod;

    private String channelRole;

    private BigDecimal price;

    private BigDecimal profit;

    private String dealerProductId;

    private Byte isAvailable;

    private Byte isDelete;

    private Date createdOn;

    private String createdBy;

    private String dataType;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getLoanPeriod() {
        return loanPeriod;
    }

    public void setLoanPeriod(String loanPeriod) {
        this.loanPeriod = loanPeriod == null ? null : loanPeriod.trim();
    }

    public String getChannelRole() {
        return channelRole;
    }

    public void setChannelRole(String channelRole) {
        this.channelRole = channelRole == null ? null : channelRole.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getProfit() {
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getDealerProductId() {
        return dealerProductId;
    }

    public void setDealerProductId(String dealerProductId) {
        this.dealerProductId = dealerProductId == null ? null : dealerProductId.trim();
    }

    public Byte getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Byte isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Byte getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
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

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", loanPeriod=").append(loanPeriod);
        sb.append(", channelRole=").append(channelRole);
        sb.append(", price=").append(price);
        sb.append(", profit=").append(profit);
        sb.append(", dealerProductId=").append(dealerProductId);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", dataType=").append(dataType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}