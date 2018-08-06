package com.lzf.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Products implements Serializable {
    private Integer id;

    private Integer processId;

    private String code;

    private String name;

    private String shortname;

    private String keywords;

    private String describe;

    private String logo;

    private String status;

    private String capitalId;

    private String loanruleId;

    private String mortgageId;

    private Boolean isGps;

    private Boolean isRobbery;

    private Boolean isDiscount;

    private String contractPackageId;

    private String createBy;

    private String updateBy;

    private String loanContType;

    private String loanContNum;

    private String loanContCopyNum;

    private String mortContType;

    private String mortContNum;

    private Boolean bankCardType;

    private String bankName;

    private String bankAccountName;

    private String bankAccountId;

    private String invoiceIds;

    private Boolean isImprest;

    private String materialReceiver;

    private String materialAddress;

    private String materialContacter;

    private String materialPhone;

    private Byte disable;

    private String minLoan;

    private String dqYear;

    private String baofeiFormulaId;

    private String loanamountFormulaId;

    private String baoeFormulaId;

    private String overloanFormulaId;

    private String isMatchLoanyear;

    private String repaymentType;

    private Byte feerate;

    private BigDecimal loanrate;

    private BigDecimal overrate;

    private Date createdAt;

    private Date updatedAt;

    private Date deletedAt;

    private Integer materialPackageId;

    private String borrowerInsuranceYear;

    private String loanmoneyRange;

    private String downpaymentRateRange;

    private Boolean intOver;

    private Boolean usedCar;

    private Boolean isGuakao;

    private String maxKm;

    private String carageLimit;

    private List<ProductLoans> productLoansList;

    public List<ProductLoans> getProductLoansList() {
        return productLoansList;
    }

    public void setProductLoansList(List<ProductLoans> productLoansList) {
        this.productLoansList = productLoansList;
    }

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProcessId() {
        return processId;
    }

    public void setProcessId(Integer processId) {
        this.processId = processId;
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

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname == null ? null : shortname.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe == null ? null : describe.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getCapitalId() {
        return capitalId;
    }

    public void setCapitalId(String capitalId) {
        this.capitalId = capitalId == null ? null : capitalId.trim();
    }

    public String getLoanruleId() {
        return loanruleId;
    }

    public void setLoanruleId(String loanruleId) {
        this.loanruleId = loanruleId == null ? null : loanruleId.trim();
    }

    public String getMortgageId() {
        return mortgageId;
    }

    public void setMortgageId(String mortgageId) {
        this.mortgageId = mortgageId == null ? null : mortgageId.trim();
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

    public Boolean getIsDiscount() {
        return isDiscount;
    }

    public void setIsDiscount(Boolean isDiscount) {
        this.isDiscount = isDiscount;
    }

    public String getContractPackageId() {
        return contractPackageId;
    }

    public void setContractPackageId(String contractPackageId) {
        this.contractPackageId = contractPackageId == null ? null : contractPackageId.trim();
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

    public String getLoanContType() {
        return loanContType;
    }

    public void setLoanContType(String loanContType) {
        this.loanContType = loanContType == null ? null : loanContType.trim();
    }

    public String getLoanContNum() {
        return loanContNum;
    }

    public void setLoanContNum(String loanContNum) {
        this.loanContNum = loanContNum == null ? null : loanContNum.trim();
    }

    public String getLoanContCopyNum() {
        return loanContCopyNum;
    }

    public void setLoanContCopyNum(String loanContCopyNum) {
        this.loanContCopyNum = loanContCopyNum == null ? null : loanContCopyNum.trim();
    }

    public String getMortContType() {
        return mortContType;
    }

    public void setMortContType(String mortContType) {
        this.mortContType = mortContType == null ? null : mortContType.trim();
    }

    public String getMortContNum() {
        return mortContNum;
    }

    public void setMortContNum(String mortContNum) {
        this.mortContNum = mortContNum == null ? null : mortContNum.trim();
    }

    public Boolean getBankCardType() {
        return bankCardType;
    }

    public void setBankCardType(Boolean bankCardType) {
        this.bankCardType = bankCardType;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    public String getBankAccountName() {
        return bankAccountName;
    }

    public void setBankAccountName(String bankAccountName) {
        this.bankAccountName = bankAccountName == null ? null : bankAccountName.trim();
    }

    public String getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(String bankAccountId) {
        this.bankAccountId = bankAccountId == null ? null : bankAccountId.trim();
    }

    public String getInvoiceIds() {
        return invoiceIds;
    }

    public void setInvoiceIds(String invoiceIds) {
        this.invoiceIds = invoiceIds == null ? null : invoiceIds.trim();
    }

    public Boolean getIsImprest() {
        return isImprest;
    }

    public void setIsImprest(Boolean isImprest) {
        this.isImprest = isImprest;
    }

    public String getMaterialReceiver() {
        return materialReceiver;
    }

    public void setMaterialReceiver(String materialReceiver) {
        this.materialReceiver = materialReceiver == null ? null : materialReceiver.trim();
    }

    public String getMaterialAddress() {
        return materialAddress;
    }

    public void setMaterialAddress(String materialAddress) {
        this.materialAddress = materialAddress == null ? null : materialAddress.trim();
    }

    public String getMaterialContacter() {
        return materialContacter;
    }

    public void setMaterialContacter(String materialContacter) {
        this.materialContacter = materialContacter == null ? null : materialContacter.trim();
    }

    public String getMaterialPhone() {
        return materialPhone;
    }

    public void setMaterialPhone(String materialPhone) {
        this.materialPhone = materialPhone == null ? null : materialPhone.trim();
    }

    public Byte getDisable() {
        return disable;
    }

    public void setDisable(Byte disable) {
        this.disable = disable;
    }

    public String getMinLoan() {
        return minLoan;
    }

    public void setMinLoan(String minLoan) {
        this.minLoan = minLoan == null ? null : minLoan.trim();
    }

    public String getDqYear() {
        return dqYear;
    }

    public void setDqYear(String dqYear) {
        this.dqYear = dqYear == null ? null : dqYear.trim();
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

    public String getOverloanFormulaId() {
        return overloanFormulaId;
    }

    public void setOverloanFormulaId(String overloanFormulaId) {
        this.overloanFormulaId = overloanFormulaId == null ? null : overloanFormulaId.trim();
    }

    public String getIsMatchLoanyear() {
        return isMatchLoanyear;
    }

    public void setIsMatchLoanyear(String isMatchLoanyear) {
        this.isMatchLoanyear = isMatchLoanyear == null ? null : isMatchLoanyear.trim();
    }

    public String getRepaymentType() {
        return repaymentType;
    }

    public void setRepaymentType(String repaymentType) {
        this.repaymentType = repaymentType == null ? null : repaymentType.trim();
    }

    public Byte getFeerate() {
        return feerate;
    }

    public void setFeerate(Byte feerate) {
        this.feerate = feerate;
    }

    public BigDecimal getLoanrate() {
        return loanrate;
    }

    public void setLoanrate(BigDecimal loanrate) {
        this.loanrate = loanrate;
    }

    public BigDecimal getOverrate() {
        return overrate;
    }

    public void setOverrate(BigDecimal overrate) {
        this.overrate = overrate;
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

    public Integer getMaterialPackageId() {
        return materialPackageId;
    }

    public void setMaterialPackageId(Integer materialPackageId) {
        this.materialPackageId = materialPackageId;
    }

    public String getBorrowerInsuranceYear() {
        return borrowerInsuranceYear;
    }

    public void setBorrowerInsuranceYear(String borrowerInsuranceYear) {
        this.borrowerInsuranceYear = borrowerInsuranceYear == null ? null : borrowerInsuranceYear.trim();
    }

    public String getLoanmoneyRange() {
        return loanmoneyRange;
    }

    public void setLoanmoneyRange(String loanmoneyRange) {
        this.loanmoneyRange = loanmoneyRange == null ? null : loanmoneyRange.trim();
    }

    public String getDownpaymentRateRange() {
        return downpaymentRateRange;
    }

    public void setDownpaymentRateRange(String downpaymentRateRange) {
        this.downpaymentRateRange = downpaymentRateRange == null ? null : downpaymentRateRange.trim();
    }

    public Boolean getIntOver() {
        return intOver;
    }

    public void setIntOver(Boolean intOver) {
        this.intOver = intOver;
    }

    public Boolean getUsedCar() {
        return usedCar;
    }

    public void setUsedCar(Boolean usedCar) {
        this.usedCar = usedCar;
    }

    public Boolean getIsGuakao() {
        return isGuakao;
    }

    public void setIsGuakao(Boolean isGuakao) {
        this.isGuakao = isGuakao;
    }

    public String getMaxKm() {
        return maxKm;
    }

    public void setMaxKm(String maxKm) {
        this.maxKm = maxKm == null ? null : maxKm.trim();
    }

    public String getCarageLimit() {
        return carageLimit;
    }

    public void setCarageLimit(String carageLimit) {
        this.carageLimit = carageLimit == null ? null : carageLimit.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", processId=").append(processId);
        sb.append(", code=").append(code);
        sb.append(", name=").append(name);
        sb.append(", shortname=").append(shortname);
        sb.append(", keywords=").append(keywords);
        sb.append(", describe=").append(describe);
        sb.append(", logo=").append(logo);
        sb.append(", status=").append(status);
        sb.append(", capitalId=").append(capitalId);
        sb.append(", loanruleId=").append(loanruleId);
        sb.append(", mortgageId=").append(mortgageId);
        sb.append(", isGps=").append(isGps);
        sb.append(", isRobbery=").append(isRobbery);
        sb.append(", isDiscount=").append(isDiscount);
        sb.append(", contractPackageId=").append(contractPackageId);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", loanContType=").append(loanContType);
        sb.append(", loanContNum=").append(loanContNum);
        sb.append(", loanContCopyNum=").append(loanContCopyNum);
        sb.append(", mortContType=").append(mortContType);
        sb.append(", mortContNum=").append(mortContNum);
        sb.append(", bankCardType=").append(bankCardType);
        sb.append(", bankName=").append(bankName);
        sb.append(", bankAccountName=").append(bankAccountName);
        sb.append(", bankAccountId=").append(bankAccountId);
        sb.append(", invoiceIds=").append(invoiceIds);
        sb.append(", isImprest=").append(isImprest);
        sb.append(", materialReceiver=").append(materialReceiver);
        sb.append(", materialAddress=").append(materialAddress);
        sb.append(", materialContacter=").append(materialContacter);
        sb.append(", materialPhone=").append(materialPhone);
        sb.append(", disable=").append(disable);
        sb.append(", minLoan=").append(minLoan);
        sb.append(", dqYear=").append(dqYear);
        sb.append(", baofeiFormulaId=").append(baofeiFormulaId);
        sb.append(", loanamountFormulaId=").append(loanamountFormulaId);
        sb.append(", baoeFormulaId=").append(baoeFormulaId);
        sb.append(", overloanFormulaId=").append(overloanFormulaId);
        sb.append(", isMatchLoanyear=").append(isMatchLoanyear);
        sb.append(", repaymentType=").append(repaymentType);
        sb.append(", feerate=").append(feerate);
        sb.append(", loanrate=").append(loanrate);
        sb.append(", overrate=").append(overrate);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append(", deletedAt=").append(deletedAt);
        sb.append(", materialPackageId=").append(materialPackageId);
        sb.append(", borrowerInsuranceYear=").append(borrowerInsuranceYear);
        sb.append(", loanmoneyRange=").append(loanmoneyRange);
        sb.append(", downpaymentRateRange=").append(downpaymentRateRange);
        sb.append(", intOver=").append(intOver);
        sb.append(", usedCar=").append(usedCar);
        sb.append(", isGuakao=").append(isGuakao);
        sb.append(", maxKm=").append(maxKm);
        sb.append(", carageLimit=").append(carageLimit);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}