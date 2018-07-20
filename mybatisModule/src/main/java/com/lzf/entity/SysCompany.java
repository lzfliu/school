package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class SysCompany implements Serializable {
    private String id;

    private String name;

    private String phone;

    private String linkman;

    private String address;

    private Date createdOn;

    private String createdBy;

    private Byte isDelete;

    private Byte isAvailable;

    private String code;

    private String creditCode;

    private String credit;

    private Boolean canAcp;

    private Boolean canSp;

    private Boolean canDealer;

    private Boolean canMortgage;

    private Boolean canCapital;

    private Boolean canHelpMortgage;

    private Boolean canVisit;

    private String coreCustomerId;

    private Boolean isQualityDealer;

    private Boolean canDocument;

    private String province;

    private String provinceName;

    private String city;

    private String cityName;

    private String district;

    private String districtName;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getCreditCode() {
        return creditCode;
    }

    public void setCreditCode(String creditCode) {
        this.creditCode = creditCode == null ? null : creditCode.trim();
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit == null ? null : credit.trim();
    }

    public Boolean getCanAcp() {
        return canAcp;
    }

    public void setCanAcp(Boolean canAcp) {
        this.canAcp = canAcp;
    }

    public Boolean getCanSp() {
        return canSp;
    }

    public void setCanSp(Boolean canSp) {
        this.canSp = canSp;
    }

    public Boolean getCanDealer() {
        return canDealer;
    }

    public void setCanDealer(Boolean canDealer) {
        this.canDealer = canDealer;
    }

    public Boolean getCanMortgage() {
        return canMortgage;
    }

    public void setCanMortgage(Boolean canMortgage) {
        this.canMortgage = canMortgage;
    }

    public Boolean getCanCapital() {
        return canCapital;
    }

    public void setCanCapital(Boolean canCapital) {
        this.canCapital = canCapital;
    }

    public Boolean getCanHelpMortgage() {
        return canHelpMortgage;
    }

    public void setCanHelpMortgage(Boolean canHelpMortgage) {
        this.canHelpMortgage = canHelpMortgage;
    }

    public Boolean getCanVisit() {
        return canVisit;
    }

    public void setCanVisit(Boolean canVisit) {
        this.canVisit = canVisit;
    }

    public String getCoreCustomerId() {
        return coreCustomerId;
    }

    public void setCoreCustomerId(String coreCustomerId) {
        this.coreCustomerId = coreCustomerId == null ? null : coreCustomerId.trim();
    }

    public Boolean getIsQualityDealer() {
        return isQualityDealer;
    }

    public void setIsQualityDealer(Boolean isQualityDealer) {
        this.isQualityDealer = isQualityDealer;
    }

    public Boolean getCanDocument() {
        return canDocument;
    }

    public void setCanDocument(Boolean canDocument) {
        this.canDocument = canDocument;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName == null ? null : provinceName.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName == null ? null : districtName.trim();
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
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", linkman=").append(linkman);
        sb.append(", address=").append(address);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", code=").append(code);
        sb.append(", creditCode=").append(creditCode);
        sb.append(", credit=").append(credit);
        sb.append(", canAcp=").append(canAcp);
        sb.append(", canSp=").append(canSp);
        sb.append(", canDealer=").append(canDealer);
        sb.append(", canMortgage=").append(canMortgage);
        sb.append(", canCapital=").append(canCapital);
        sb.append(", canHelpMortgage=").append(canHelpMortgage);
        sb.append(", canVisit=").append(canVisit);
        sb.append(", coreCustomerId=").append(coreCustomerId);
        sb.append(", isQualityDealer=").append(isQualityDealer);
        sb.append(", canDocument=").append(canDocument);
        sb.append(", province=").append(province);
        sb.append(", provinceName=").append(provinceName);
        sb.append(", city=").append(city);
        sb.append(", cityName=").append(cityName);
        sb.append(", district=").append(district);
        sb.append(", districtName=").append(districtName);
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