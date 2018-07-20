package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BizCapital implements Serializable {
    private String id;

    private String companyId;

    private String repayType;

    private String cardType;

    private String firstBeneficiary;

    private String repayDayType;

    private String loanSignType;

    private String rateType;

    private String accountNo;

    private String accountBank;

    private String accountOwner;

    private Boolean allowPrivateAccount;

    private String mortgages;

    private BigDecimal maxLoanRate;

    private BigDecimal overrate;

    private String createdBy;

    private Boolean isAvailable;

    private Date createdOn;

    private Boolean isDelete;

    private BigDecimal minPayDown;

    private BigDecimal rateDelay;

    private String transferKey;

    private String totalDocumentId;

    private Boolean isNeedAppointment;

    private String orderDateProvider;

    private String status;

    private String serialNum;

    private String dataType;

    private Date deleteAt;

    private String checkRemark;

    private String updateRemark;

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

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }

    public String getFirstBeneficiary() {
        return firstBeneficiary;
    }

    public void setFirstBeneficiary(String firstBeneficiary) {
        this.firstBeneficiary = firstBeneficiary == null ? null : firstBeneficiary.trim();
    }

    public String getRepayDayType() {
        return repayDayType;
    }

    public void setRepayDayType(String repayDayType) {
        this.repayDayType = repayDayType == null ? null : repayDayType.trim();
    }

    public String getLoanSignType() {
        return loanSignType;
    }

    public void setLoanSignType(String loanSignType) {
        this.loanSignType = loanSignType == null ? null : loanSignType.trim();
    }

    public String getRateType() {
        return rateType;
    }

    public void setRateType(String rateType) {
        this.rateType = rateType == null ? null : rateType.trim();
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo == null ? null : accountNo.trim();
    }

    public String getAccountBank() {
        return accountBank;
    }

    public void setAccountBank(String accountBank) {
        this.accountBank = accountBank == null ? null : accountBank.trim();
    }

    public String getAccountOwner() {
        return accountOwner;
    }

    public void setAccountOwner(String accountOwner) {
        this.accountOwner = accountOwner == null ? null : accountOwner.trim();
    }

    public Boolean getAllowPrivateAccount() {
        return allowPrivateAccount;
    }

    public void setAllowPrivateAccount(Boolean allowPrivateAccount) {
        this.allowPrivateAccount = allowPrivateAccount;
    }

    public String getMortgages() {
        return mortgages;
    }

    public void setMortgages(String mortgages) {
        this.mortgages = mortgages == null ? null : mortgages.trim();
    }

    public BigDecimal getMaxLoanRate() {
        return maxLoanRate;
    }

    public void setMaxLoanRate(BigDecimal maxLoanRate) {
        this.maxLoanRate = maxLoanRate;
    }

    public BigDecimal getOverrate() {
        return overrate;
    }

    public void setOverrate(BigDecimal overrate) {
        this.overrate = overrate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public BigDecimal getMinPayDown() {
        return minPayDown;
    }

    public void setMinPayDown(BigDecimal minPayDown) {
        this.minPayDown = minPayDown;
    }

    public BigDecimal getRateDelay() {
        return rateDelay;
    }

    public void setRateDelay(BigDecimal rateDelay) {
        this.rateDelay = rateDelay;
    }

    public String getTransferKey() {
        return transferKey;
    }

    public void setTransferKey(String transferKey) {
        this.transferKey = transferKey == null ? null : transferKey.trim();
    }

    public String getTotalDocumentId() {
        return totalDocumentId;
    }

    public void setTotalDocumentId(String totalDocumentId) {
        this.totalDocumentId = totalDocumentId == null ? null : totalDocumentId.trim();
    }

    public Boolean getIsNeedAppointment() {
        return isNeedAppointment;
    }

    public void setIsNeedAppointment(Boolean isNeedAppointment) {
        this.isNeedAppointment = isNeedAppointment;
    }

    public String getOrderDateProvider() {
        return orderDateProvider;
    }

    public void setOrderDateProvider(String orderDateProvider) {
        this.orderDateProvider = orderDateProvider == null ? null : orderDateProvider.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public Date getDeleteAt() {
        return deleteAt;
    }

    public void setDeleteAt(Date deleteAt) {
        this.deleteAt = deleteAt;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    public String getUpdateRemark() {
        return updateRemark;
    }

    public void setUpdateRemark(String updateRemark) {
        this.updateRemark = updateRemark == null ? null : updateRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", companyId=").append(companyId);
        sb.append(", repayType=").append(repayType);
        sb.append(", cardType=").append(cardType);
        sb.append(", firstBeneficiary=").append(firstBeneficiary);
        sb.append(", repayDayType=").append(repayDayType);
        sb.append(", loanSignType=").append(loanSignType);
        sb.append(", rateType=").append(rateType);
        sb.append(", accountNo=").append(accountNo);
        sb.append(", accountBank=").append(accountBank);
        sb.append(", accountOwner=").append(accountOwner);
        sb.append(", allowPrivateAccount=").append(allowPrivateAccount);
        sb.append(", mortgages=").append(mortgages);
        sb.append(", maxLoanRate=").append(maxLoanRate);
        sb.append(", overrate=").append(overrate);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", minPayDown=").append(minPayDown);
        sb.append(", rateDelay=").append(rateDelay);
        sb.append(", transferKey=").append(transferKey);
        sb.append(", totalDocumentId=").append(totalDocumentId);
        sb.append(", isNeedAppointment=").append(isNeedAppointment);
        sb.append(", orderDateProvider=").append(orderDateProvider);
        sb.append(", status=").append(status);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", dataType=").append(dataType);
        sb.append(", deleteAt=").append(deleteAt);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", updateRemark=").append(updateRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}