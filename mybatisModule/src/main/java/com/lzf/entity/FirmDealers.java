package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class FirmDealers implements Serializable {
    private Integer id;

    private String name;

    private String code;

    private Integer pId;

    private String pIds;

    private String mobile;

    private String linkman;

    private String fixPhone;

    private String email;

    private String province;

    private String city;

    private String district;

    private String devicePledge;

    private String margin;

    private String address;

    private Integer documentId;

    private Byte business;

    private String trusteeshipCard;

    private String collectionCard;

    private String collectionCardBank;

    private String enterpriseCode;

    private String enterprise;

    private String collectionCardImg;

    private String collectionUsername;

    private String dqUsername;

    private String dqPassword;

    private Byte pledge;

    private String pledgeIds;

    private Integer invoiceLater;

    private Byte loanStop;

    private Boolean disable;

    private String createBy;

    private String updateBy;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Byte status;

    private String firmLinkman;

    private String firmMobile;

    private String firmAddress;

    private String gpsdevices;

    private Byte isGood;

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


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpIds() {
        return pIds;
    }

    public void setpIds(String pIds) {
        this.pIds = pIds == null ? null : pIds.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getFixPhone() {
        return fixPhone;
    }

    public void setFixPhone(String fixPhone) {
        this.fixPhone = fixPhone == null ? null : fixPhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
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

    public String getDevicePledge() {
        return devicePledge;
    }

    public void setDevicePledge(String devicePledge) {
        this.devicePledge = devicePledge == null ? null : devicePledge.trim();
    }

    public String getMargin() {
        return margin;
    }

    public void setMargin(String margin) {
        this.margin = margin == null ? null : margin.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getDocumentId() {
        return documentId;
    }

    public void setDocumentId(Integer documentId) {
        this.documentId = documentId;
    }

    public Byte getBusiness() {
        return business;
    }

    public void setBusiness(Byte business) {
        this.business = business;
    }

    public String getTrusteeshipCard() {
        return trusteeshipCard;
    }

    public void setTrusteeshipCard(String trusteeshipCard) {
        this.trusteeshipCard = trusteeshipCard == null ? null : trusteeshipCard.trim();
    }

    public String getCollectionCard() {
        return collectionCard;
    }

    public void setCollectionCard(String collectionCard) {
        this.collectionCard = collectionCard == null ? null : collectionCard.trim();
    }

    public String getCollectionCardBank() {
        return collectionCardBank;
    }

    public void setCollectionCardBank(String collectionCardBank) {
        this.collectionCardBank = collectionCardBank == null ? null : collectionCardBank.trim();
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode == null ? null : enterpriseCode.trim();
    }

    public String getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(String enterprise) {
        this.enterprise = enterprise == null ? null : enterprise.trim();
    }

    public String getCollectionCardImg() {
        return collectionCardImg;
    }

    public void setCollectionCardImg(String collectionCardImg) {
        this.collectionCardImg = collectionCardImg == null ? null : collectionCardImg.trim();
    }

    public String getCollectionUsername() {
        return collectionUsername;
    }

    public void setCollectionUsername(String collectionUsername) {
        this.collectionUsername = collectionUsername == null ? null : collectionUsername.trim();
    }

    public String getDqUsername() {
        return dqUsername;
    }

    public void setDqUsername(String dqUsername) {
        this.dqUsername = dqUsername == null ? null : dqUsername.trim();
    }

    public String getDqPassword() {
        return dqPassword;
    }

    public void setDqPassword(String dqPassword) {
        this.dqPassword = dqPassword == null ? null : dqPassword.trim();
    }

    public Byte getPledge() {
        return pledge;
    }

    public void setPledge(Byte pledge) {
        this.pledge = pledge;
    }

    public String getPledgeIds() {
        return pledgeIds;
    }

    public void setPledgeIds(String pledgeIds) {
        this.pledgeIds = pledgeIds == null ? null : pledgeIds.trim();
    }

    public Integer getInvoiceLater() {
        return invoiceLater;
    }

    public void setInvoiceLater(Integer invoiceLater) {
        this.invoiceLater = invoiceLater;
    }

    public Byte getLoanStop() {
        return loanStop;
    }

    public void setLoanStop(Byte loanStop) {
        this.loanStop = loanStop;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
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

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getFirmLinkman() {
        return firmLinkman;
    }

    public void setFirmLinkman(String firmLinkman) {
        this.firmLinkman = firmLinkman == null ? null : firmLinkman.trim();
    }

    public String getFirmMobile() {
        return firmMobile;
    }

    public void setFirmMobile(String firmMobile) {
        this.firmMobile = firmMobile == null ? null : firmMobile.trim();
    }

    public String getFirmAddress() {
        return firmAddress;
    }

    public void setFirmAddress(String firmAddress) {
        this.firmAddress = firmAddress == null ? null : firmAddress.trim();
    }

    public String getGpsdevices() {
        return gpsdevices;
    }

    public void setGpsdevices(String gpsdevices) {
        this.gpsdevices = gpsdevices == null ? null : gpsdevices.trim();
    }

    public Byte getIsGood() {
        return isGood;
    }

    public void setIsGood(Byte isGood) {
        this.isGood = isGood;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", code=").append(code);
        sb.append(", pId=").append(pId);
        sb.append(", pIds=").append(pIds);
        sb.append(", mobile=").append(mobile);
        sb.append(", linkman=").append(linkman);
        sb.append(", fixPhone=").append(fixPhone);
        sb.append(", email=").append(email);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", district=").append(district);
        sb.append(", devicePledge=").append(devicePledge);
        sb.append(", margin=").append(margin);
        sb.append(", address=").append(address);
        sb.append(", documentId=").append(documentId);
        sb.append(", business=").append(business);
        sb.append(", trusteeshipCard=").append(trusteeshipCard);
        sb.append(", collectionCard=").append(collectionCard);
        sb.append(", collectionCardBank=").append(collectionCardBank);
        sb.append(", enterpriseCode=").append(enterpriseCode);
        sb.append(", enterprise=").append(enterprise);
        sb.append(", collectionCardImg=").append(collectionCardImg);
        sb.append(", collectionUsername=").append(collectionUsername);
        sb.append(", dqUsername=").append(dqUsername);
        sb.append(", dqPassword=").append(dqPassword);
        sb.append(", pledge=").append(pledge);
        sb.append(", pledgeIds=").append(pledgeIds);
        sb.append(", invoiceLater=").append(invoiceLater);
        sb.append(", loanStop=").append(loanStop);
        sb.append(", disable=").append(disable);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", status=").append(status);
        sb.append(", firmLinkman=").append(firmLinkman);
        sb.append(", firmMobile=").append(firmMobile);
        sb.append(", firmAddress=").append(firmAddress);
        sb.append(", gpsdevices=").append(gpsdevices);
        sb.append(", isGood=").append(isGood);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}