package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class Product implements Serializable {
    private String id;

    private String code;

    private String name;

    private String describes;

    private String status;

    private String capitalCompanyId;

    private String financialCompanyId;

    private String lendersCompanyId;

    private Boolean isGps;

    private Boolean isRobbery;

    private Boolean isImprest;

    private String discount;

    private String monthFormulaId;

    private String baofeiFormulaId;

    private String loanamountFormulaId;

    private String baoeFormulaId;

    private String isMatchLoanyear;

    private Boolean feerate;

    private BigDecimal overrate;

    private String overrateFormulaId;

    private String materialPackageId;

    private Integer firstUpper;

    private Integer perUpper;

    private String repayType;

    private BigDecimal minDownPayment;

    private BigDecimal maxDownPayment;

    private BigDecimal discountAmount;

    private String devices;

    private BigDecimal maxLoanRate;

    private BigDecimal minLoan;

    private BigDecimal maxLoan;

    private Date createdOn;

    private String createdBy;

    private Byte isDelete;

    private Byte isAvailable;

    private String insuranceProductCode;

    private String productType;

    private Boolean isAffiliated;

    private String overdraftFormulaId;

    private Double maxMileage;

    private String businessType;

    private Byte examine;

    private String dataType;

    private String audit;

    private String serialNum;

    private String checkRemark;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescribes() {
        return describes;
    }

    public void setDescribes(String describes) {
        this.describes = describes == null ? null : describes.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCapitalCompanyId() {
        return capitalCompanyId;
    }

    public void setCapitalCompanyId(String capitalCompanyId) {
        this.capitalCompanyId = capitalCompanyId == null ? null : capitalCompanyId.trim();
    }

    public String getFinancialCompanyId() {
        return financialCompanyId;
    }

    public void setFinancialCompanyId(String financialCompanyId) {
        this.financialCompanyId = financialCompanyId == null ? null : financialCompanyId.trim();
    }

    public String getLendersCompanyId() {
        return lendersCompanyId;
    }

    public void setLendersCompanyId(String lendersCompanyId) {
        this.lendersCompanyId = lendersCompanyId == null ? null : lendersCompanyId.trim();
    }

    public Boolean getIsGps() {
        return isGps;
    }

    public void setIsGps(Boolean isGps) {
        this.isGps = isGps;
    }

    public Boolean getIsRobbery() {
        return isRobbery;
    }

    public void setIsRobbery(Boolean isRobbery) {
        this.isRobbery = isRobbery;
    }

    public Boolean getIsImprest() {
        return isImprest;
    }

    public void setIsImprest(Boolean isImprest) {
        this.isImprest = isImprest;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount == null ? null : discount.trim();
    }

    public String getMonthFormulaId() {
        return monthFormulaId;
    }

    public void setMonthFormulaId(String monthFormulaId) {
        this.monthFormulaId = monthFormulaId == null ? null : monthFormulaId.trim();
    }

    public String getBaofeiFormulaId() {
        return baofeiFormulaId;
    }

    public void setBaofeiFormulaId(String baofeiFormulaId) {
        this.baofeiFormulaId = baofeiFormulaId == null ? null : baofeiFormulaId.trim();
    }

    public String getLoanamountFormulaId() {
        return loanamountFormulaId;
    }

    public void setLoanamountFormulaId(String loanamountFormulaId) {
        this.loanamountFormulaId = loanamountFormulaId == null ? null : loanamountFormulaId.trim();
    }

    public String getBaoeFormulaId() {
        return baoeFormulaId;
    }

    public void setBaoeFormulaId(String baoeFormulaId) {
        this.baoeFormulaId = baoeFormulaId == null ? null : baoeFormulaId.trim();
    }

    public String getIsMatchLoanyear() {
        return isMatchLoanyear;
    }

    public void setIsMatchLoanyear(String isMatchLoanyear) {
        this.isMatchLoanyear = isMatchLoanyear == null ? null : isMatchLoanyear.trim();
    }

    public Boolean getFeerate() {
        return feerate;
    }

    public void setFeerate(Boolean feerate) {
        this.feerate = feerate;
    }

    public BigDecimal getOverrate() {
        return overrate;
    }

    public void setOverrate(BigDecimal overrate) {
        this.overrate = overrate;
    }

    public String getOverrateFormulaId() {
        return overrateFormulaId;
    }

    public void setOverrateFormulaId(String overrateFormulaId) {
        this.overrateFormulaId = overrateFormulaId == null ? null : overrateFormulaId.trim();
    }

    public String getMaterialPackageId() {
        return materialPackageId;
    }

    public void setMaterialPackageId(String materialPackageId) {
        this.materialPackageId = materialPackageId == null ? null : materialPackageId.trim();
    }

    public Integer getFirstUpper() {
        return firstUpper;
    }

    public void setFirstUpper(Integer firstUpper) {
        this.firstUpper = firstUpper;
    }

    public Integer getPerUpper() {
        return perUpper;
    }

    public void setPerUpper(Integer perUpper) {
        this.perUpper = perUpper;
    }

    public String getRepayType() {
        return repayType;
    }

    public void setRepayType(String repayType) {
        this.repayType = repayType == null ? null : repayType.trim();
    }

    public BigDecimal getMinDownPayment() {
        return minDownPayment;
    }

    public void setMinDownPayment(BigDecimal minDownPayment) {
        this.minDownPayment = minDownPayment;
    }

    public BigDecimal getMaxDownPayment() {
        return maxDownPayment;
    }

    public void setMaxDownPayment(BigDecimal maxDownPayment) {
        this.maxDownPayment = maxDownPayment;
    }

    public BigDecimal getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(BigDecimal discountAmount) {
        this.discountAmount = discountAmount;
    }

    public String getDevices() {
        return devices;
    }

    public void setDevices(String devices) {
        this.devices = devices == null ? null : devices.trim();
    }

    public BigDecimal getMaxLoanRate() {
        return maxLoanRate;
    }

    public void setMaxLoanRate(BigDecimal maxLoanRate) {
        this.maxLoanRate = maxLoanRate;
    }

    public BigDecimal getMinLoan() {
        return minLoan;
    }

    public void setMinLoan(BigDecimal minLoan) {
        this.minLoan = minLoan;
    }

    public BigDecimal getMaxLoan() {
        return maxLoan;
    }

    public void setMaxLoan(BigDecimal maxLoan) {
        this.maxLoan = maxLoan;
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

    public String getInsuranceProductCode() {
        return insuranceProductCode;
    }

    public void setInsuranceProductCode(String insuranceProductCode) {
        this.insuranceProductCode = insuranceProductCode == null ? null : insuranceProductCode.trim();
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public Boolean getIsAffiliated() {
        return isAffiliated;
    }

    public void setIsAffiliated(Boolean isAffiliated) {
        this.isAffiliated = isAffiliated;
    }

    public String getOverdraftFormulaId() {
        return overdraftFormulaId;
    }

    public void setOverdraftFormulaId(String overdraftFormulaId) {
        this.overdraftFormulaId = overdraftFormulaId == null ? null : overdraftFormulaId.trim();
    }

    public Double getMaxMileage() {
        return maxMileage;
    }

    public void setMaxMileage(Double maxMileage) {
        this.maxMileage = maxMileage;
    }

    public String getBusinessType() {
        return businessType;
    }

    public void setBusinessType(String businessType) {
        this.businessType = businessType == null ? null : businessType.trim();
    }

    public Byte getExamine() {
        return examine;
    }

    public void setExamine(Byte examine) {
        this.examine = examine;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType == null ? null : dataType.trim();
    }

    public String getAudit() {
        return audit;
    }

    public void setAudit(String audit) {
        this.audit = audit == null ? null : audit.trim();
    }

    public String getSerialNum() {
        return serialNum;
    }

    public void setSerialNum(String serialNum) {
        this.serialNum = serialNum == null ? null : serialNum.trim();
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark == null ? null : checkRemark.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", describes=").append(describes);
        sb.append(", status=").append(status);
        sb.append(", capitalCompanyId=").append(capitalCompanyId);
        sb.append(", financialCompanyId=").append(financialCompanyId);
        sb.append(", lendersCompanyId=").append(lendersCompanyId);
        sb.append(", isGps=").append(isGps);
        sb.append(", isRobbery=").append(isRobbery);
        sb.append(", isImprest=").append(isImprest);
        sb.append(", discount=").append(discount);
        sb.append(", monthFormulaId=").append(monthFormulaId);
        sb.append(", baofeiFormulaId=").append(baofeiFormulaId);
        sb.append(", loanamountFormulaId=").append(loanamountFormulaId);
        sb.append(", baoeFormulaId=").append(baoeFormulaId);
        sb.append(", isMatchLoanyear=").append(isMatchLoanyear);
        sb.append(", feerate=").append(feerate);
        sb.append(", overrate=").append(overrate);
        sb.append(", overrateFormulaId=").append(overrateFormulaId);
        sb.append(", materialPackageId=").append(materialPackageId);
        sb.append(", firstUpper=").append(firstUpper);
        sb.append(", perUpper=").append(perUpper);
        sb.append(", repayType=").append(repayType);
        sb.append(", minDownPayment=").append(minDownPayment);
        sb.append(", maxDownPayment=").append(maxDownPayment);
        sb.append(", discountAmount=").append(discountAmount);
        sb.append(", devices=").append(devices);
        sb.append(", maxLoanRate=").append(maxLoanRate);
        sb.append(", minLoan=").append(minLoan);
        sb.append(", maxLoan=").append(maxLoan);
        sb.append(", createdOn=").append(createdOn);
        sb.append(", createdBy=").append(createdBy);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", isAvailable=").append(isAvailable);
        sb.append(", insuranceProductCode=").append(insuranceProductCode);
        sb.append(", productType=").append(productType);
        sb.append(", isAffiliated=").append(isAffiliated);
        sb.append(", overdraftFormulaId=").append(overdraftFormulaId);
        sb.append(", maxMileage=").append(maxMileage);
        sb.append(", businessType=").append(businessType);
        sb.append(", examine=").append(examine);
        sb.append(", dataType=").append(dataType);
        sb.append(", audit=").append(audit);
        sb.append(", serialNum=").append(serialNum);
        sb.append(", checkRemark=").append(checkRemark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}