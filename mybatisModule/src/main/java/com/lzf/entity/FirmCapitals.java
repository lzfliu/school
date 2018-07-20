package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class FirmCapitals implements Serializable {
    private Integer id;

    private String name;

    private String linkman;

    private String loanLinkman;

    private String loanPhone;

    private String loanMobile;

    private String loanFax;

    private String loanPostcode;

    private String mobile;

    private String province;

    private String city;

    private String district;

    private String address;

    private Integer contractTemplateId;

    private String dueDate;

    private String enterprise;

    private Byte bankCardType;

    private String isprefee;

    private Boolean disable;

    private String firstBeneficiary;

    private String updateBy;

    private String createBy;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private String status;

    private Boolean supportprivate;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getLoanLinkman() {
        return loanLinkman;
    }

    public void setLoanLinkman(String loanLinkman) {
        this.loanLinkman = loanLinkman == null ? null : loanLinkman.trim();
    }

    public String getLoanPhone() {
        return loanPhone;
    }

    public void setLoanPhone(String loanPhone) {
        this.loanPhone = loanPhone == null ? null : loanPhone.trim();
    }

    public String getLoanMobile() {
        return loanMobile;
    }

    public void setLoanMobile(String loanMobile) {
        this.loanMobile = loanMobile == null ? null : loanMobile.trim();
    }

    public String getLoanFax() {
        return loanFax;
    }

    public void setLoanFax(String loanFax) {
        this.loanFax = loanFax == null ? null : loanFax.trim();
    }

    public String getLoanPostcode() {
        return loanPostcode;
    }

    public void setLoanPostcode(String loanPostcode) {
        this.loanPostcode = loanPostcode == null ? null : loanPostcode.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getContractTemplateId() {
        return contractTemplateId;
    }

    public void setContractTemplateId(Integer contractTemplateId) {
        this.contractTemplateId = contractTemplateId;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate == null ? null : dueDate.trim();
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise == null ? null : enterprise.trim();
    }

    public Byte getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Byte bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getIsprefee() {
        return isprefee;
    }

    public void setIsprefee(String isprefee) {
        this.isprefee = isprefee == null ? null : isprefee.trim();
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getFirstBeneficiary() {
        return firstBeneficiary;
    }

    public void setFirstBeneficiary(String firstBeneficiary) {
        this.firstBeneficiary = firstBeneficiary == null ? null : firstBeneficiary.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Boolean getSupportprivate() {
        return supportprivate;
    }

    public void setSupportprivate(Boolean supportprivate) {
        this.supportprivate = supportprivate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", linkman=").append(linkman);
        sb.append(", loanLinkman=").append(loanLinkman);
        sb.append(", loanPhone=").append(loanPhone);
        sb.append(", loanMobile=").append(loanMobile);
        sb.append(", loanFax=").append(loanFax);
        sb.append(", loanPostcode=").append(loanPostcode);
        sb.append(", mobile=").append(mobile);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", address=").append(address);
        sb.append(", contractTemplateId=").append(contractTemplateId);
        sb.append(", dueDate=").append(dueDate);
        sb.append(", enterprise=").append(enterprise);
        sb.append(", bankCardType=").append(bankCardType);
        sb.append(", isprefee=").append(isprefee);
        sb.append(", disable=").append(disable);
        sb.append(", firstBeneficiary=").append(firstBeneficiary);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createBy=").append(createBy);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", status=").append(status);
        sb.append(", supportprivate=").append(supportprivate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}