package com.lzf.entity;

import java.io.Serializable;
import java.util.Date;

public class BizMortgage implements Serializable {
    private String id;

    private String companyId;

    private String materialPackageId;

    private String mortgageSignType;

    private Boolean isAvailable;

    private String createdBy;

    private Date createdOn;

    private Boolean isDelete;

    private String status;

    private String serialNum;

    private String dataType;

    private Date deleteAt;

    private String cities;

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

    public String getMaterialPackageId() {
        return materialPackageId;
    }

    public void setMaterialPackageId(String materialPackageId) {
        this.materialPackageId = materialPackageId == null ? null : materialPackageId.trim();
    }

    public String getMortgageSignType() {
        return mortgageSignType;
    }

    public void setMortgageSignType(String mortgageSignType) {
        this.mortgageSignType = mortgageSignType == null ? null : mortgageSignType.trim();
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

    public String getCities() {
        return cities;
    }

    public void setCities(String cities) {
        this.cities = cities == null ? null : cities.trim();
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
        sb.append(", materialPackageId=").append(materialPackageId);
        sb.append(", mortgageSignType=").append(mortgageSignType);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", status=").append(status);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", dataType=").append(dataType);
        sb.append(", deleteAt=").append(deleteAt);
        sb.append(", cities=").append(cities);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", updateRemark=").append(updateRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}