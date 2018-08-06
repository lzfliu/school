package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class ProductFlow implements Serializable ,Cloneable{
    private String id;

    private String productId;

    private String qualificationTemplateId;

    private String loanTemplateId;

    private Byte needInsurance;

    private String insuranceTemplateId;

    private String capitalTemplateId;

    private String pledgeTemplateId;

    private Boolean isAvailable;

    private String createdBy;

    private Date createdOn;

    private Boolean isDelete;

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

    public String getQualificationTemplateId() {
        return qualificationTemplateId;
    }

    public void setQualificationTemplateId(String qualificationTemplateId) {
        this.qualificationTemplateId = qualificationTemplateId == null ? null : qualificationTemplateId.trim();
    }

    public String getLoanTemplateId() {
        return loanTemplateId;
    }

    public void setLoanTemplateId(String loanTemplateId) {
        this.loanTemplateId = loanTemplateId == null ? null : loanTemplateId.trim();
    }

    public Byte getNeedInsurance() {
        return needInsurance;
    }

    public void setNeedInsurance(Byte needInsurance) {
        this.needInsurance = needInsurance;
    }

    public String getInsuranceTemplateId() {
        return insuranceTemplateId;
    }

    public void setInsuranceTemplateId(String insuranceTemplateId) {
        this.insuranceTemplateId = insuranceTemplateId == null ? null : insuranceTemplateId.trim();
    }

    public String getCapitalTemplateId() {
        return capitalTemplateId;
    }

    public void setCapitalTemplateId(String capitalTemplateId) {
        this.capitalTemplateId = capitalTemplateId == null ? null : capitalTemplateId.trim();
    }

    public String getPledgeTemplateId() {
        return pledgeTemplateId;
    }

    public void setPledgeTemplateId(String pledgeTemplateId) {
        this.pledgeTemplateId = pledgeTemplateId == null ? null : pledgeTemplateId.trim();
    }

    public Boolean getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productId=").append(productId);
        sb.append(", qualificationTemplateId=").append(qualificationTemplateId);
        sb.append(", loanTemplateId=").append(loanTemplateId);
        sb.append(", needInsurance=").append(needInsurance);
        sb.append(", insuranceTemplateId=").append(insuranceTemplateId);
        sb.append(", capitalTemplateId=").append(capitalTemplateId);
        sb.append(", pledgeTemplateId=").append(pledgeTemplateId);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public ProductFlow clone() throws CloneNotSupportedException {
        return (ProductFlow) super.clone();
    }
}