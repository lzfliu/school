package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BizChannel implements Serializable {
    private String id;

    private String channelRole;

    private String companyId;

    private String parentId;

    private Byte loanStop;

    private String trustAccountNo;

    private String trustAccountBank;

    private String trustAccountOwner;

    private String reciveAccountNo;

    private String reciveAccountBank;

    private String reciveAccountOwner;

    private Integer sequence;

    private Date createdOn;

    private String createdBy;

    private Byte isDelete;

    private Byte isAvailable;

    private String entrustAccountNo;

    private String entrustAccountBank;

    private String entrustAccountOwner;

    private Boolean lazyUpload;

    private Boolean qualityDealer;

    private String status;

    private String serialNum;

    private String dataType;

    private Date deleteAt;

    private BigDecimal bond;

    private String trustAccountUp;

    private String reciveAccountUp;

    private String entrustAccountUp;

    private String checkRemark;

    private String updateRemark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getChannelRole() {
        return channelRole;
    }

    public void setChannelRole(String channelRole) {
        this.channelRole = channelRole == null ? null : channelRole.trim();
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId == null ? null : companyId.trim();
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId == null ? null : parentId.trim();
    }

    public Byte getLoanStop() {
        return loanStop;
    }

    public void setLoanStop(Byte loanStop) {
        this.loanStop = loanStop;
    }

    public String getTrustAccountNo() {
        return trustAccountNo;
    }

    public void setTrustAccountNo(String trustAccountNo) {
        this.trustAccountNo = trustAccountNo == null ? null : trustAccountNo.trim();
    }

    public String getTrustAccountBank() {
        return trustAccountBank;
    }

    public void setTrustAccountBank(String trustAccountBank) {
        this.trustAccountBank = trustAccountBank == null ? null : trustAccountBank.trim();
    }

    public String getTrustAccountOwner() {
        return trustAccountOwner;
    }

    public void setTrustAccountOwner(String trustAccountOwner) {
        this.trustAccountOwner = trustAccountOwner == null ? null : trustAccountOwner.trim();
    }

    public String getReciveAccountNo() {
        return reciveAccountNo;
    }

    public void setReciveAccountNo(String reciveAccountNo) {
        this.reciveAccountNo = reciveAccountNo == null ? null : reciveAccountNo.trim();
    }

    public String getReciveAccountBank() {
        return reciveAccountBank;
    }

    public void setReciveAccountBank(String reciveAccountBank) {
        this.reciveAccountBank = reciveAccountBank == null ? null : reciveAccountBank.trim();
    }

    public String getReciveAccountOwner() {
        return reciveAccountOwner;
    }

    public void setReciveAccountOwner(String reciveAccountOwner) {
        this.reciveAccountOwner = reciveAccountOwner == null ? null : reciveAccountOwner.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
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

    public String getEntrustAccountNo() {
        return entrustAccountNo;
    }

    public void setEntrustAccountNo(String entrustAccountNo) {
        this.entrustAccountNo = entrustAccountNo == null ? null : entrustAccountNo.trim();
    }

    public String getEntrustAccountBank() {
        return entrustAccountBank;
    }

    public void setEntrustAccountBank(String entrustAccountBank) {
        this.entrustAccountBank = entrustAccountBank == null ? null : entrustAccountBank.trim();
    }

    public String getEntrustAccountOwner() {
        return entrustAccountOwner;
    }

    public void setEntrustAccountOwner(String entrustAccountOwner) {
        this.entrustAccountOwner = entrustAccountOwner == null ? null : entrustAccountOwner.trim();
    }

    public Boolean getLazyUpload() {
        return lazyUpload;
    }

    public void setLazyUpload(Boolean lazyUpload) {
        this.lazyUpload = lazyUpload;
    }

    public Boolean getQualityDealer() {
        return qualityDealer;
    }

    public void setQualityDealer(Boolean qualityDealer) {
        this.qualityDealer = qualityDealer;
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

    public BigDecimal getBond() {
        return bond;
    }

    public void setBond(BigDecimal bond) {
        this.bond = bond;
    }

    public String getTrustAccountUp() {
        return trustAccountUp;
    }

    public void setTrustAccountUp(String trustAccountUp) {
        this.trustAccountUp = trustAccountUp == null ? null : trustAccountUp.trim();
    }

    public String getReciveAccountUp() {
        return reciveAccountUp;
    }

    public void setReciveAccountUp(String reciveAccountUp) {
        this.reciveAccountUp = reciveAccountUp == null ? null : reciveAccountUp.trim();
    }

    public String getEntrustAccountUp() {
        return entrustAccountUp;
    }

    public void setEntrustAccountUp(String entrustAccountUp) {
        this.entrustAccountUp = entrustAccountUp == null ? null : entrustAccountUp.trim();
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
        sb.append(", channelRole=").append(channelRole);
        sb.append(", companyId=").append(companyId);
        sb.append(", parentId=").append(parentId);
        sb.append(", loanStop=").append(loanStop);
        sb.append(", trustAccountNo=").append(trustAccountNo);
        sb.append(", trustAccountBank=").append(trustAccountBank);
        sb.append(", trustAccountOwner=").append(trustAccountOwner);
        sb.append(", reciveAccountNo=").append(reciveAccountNo);
        sb.append(", reciveAccountBank=").append(reciveAccountBank);
        sb.append(", reciveAccountOwner=").append(reciveAccountOwner);
        sb.append(", sequence=").append(sequence);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", entrustAccountNo=").append(entrustAccountNo);
        sb.append(", entrustAccountBank=").append(entrustAccountBank);
        sb.append(", entrustAccountOwner=").append(entrustAccountOwner);
        sb.append(", lazyUpload=").append(lazyUpload);
        sb.append(", qualityDealer=").append(qualityDealer);
        sb.append(", status=").append(status);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", dataType=").append(dataType);
        sb.append(", deleteAt=").append(deleteAt);
        sb.append(", bond=").append(bond);
        sb.append(", trustAccountUp=").append(trustAccountUp);
        sb.append(", reciveAccountUp=").append(reciveAccountUp);
        sb.append(", entrustAccountUp=").append(entrustAccountUp);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", updateRemark=").append(updateRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}