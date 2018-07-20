package com.lzf.entity;;import java.util.Date;

public class CustomerStaff  {

    protected String id;
    protected Date createTime;
    protected Date updateTime;
    protected String createBy;
    protected String updateBy;
    protected Boolean available;
    protected Boolean delete;


    /**
     * 客户id，customer表id
     */
    private String customerId;

    private String customerName;

    private String loginName;

    private String password;

    /**
     * 员工姓名
     */
    private String staffName;

    /**
     * 联系电话
     */
    private String contactMobile;

    private String email;

    /**
     * 生日
     */
    private Long birth;

    /**
     * 省id
     */
    private String province;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 市
     */
    private String city;

    /**
     * 区
     */
    private String district;

    /**
     * 地址
     */
    private String address;

    /**
     * 性别 0女 1男
     */
    private String gender;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateBy() {
        return this.createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getUpdateBy() {
        return this.updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean isAvailable() {
        return this.available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public Boolean isDelete() {
        return this.delete;
    }

    public void setDelete(Boolean delete) {
        this.delete = delete;
    }

    /**
     * 获取客户id，customer表id
     *
     * @return customer_id - 客户id，customer表id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * 设置客户id，customer表id
     *
     * @param customerId 客户id，customer表id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * 获取员工姓名
     *
     * @return staff_name - 员工姓名
     */
    public String getStaffName() {
        return staffName;
    }

    /**
     * 设置员工姓名
     *
     * @param staffName 员工姓名
     */
    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    /**
     * 获取联系电话
     *
     * @return contact_mobile - 联系电话
     */
    public String getContactMobile() {
        return contactMobile;
    }

    /**
     * 设置联系电话
     *
     * @param contactMobile 联系电话
     */
    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    /**
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取生日
     *
     * @return birth - 生日
     */
    public Long getBirth() {
        return birth;
    }

    /**
     * 设置生日
     *
     * @param birth 生日
     */
    public void setBirth(Long birth) {
        this.birth = birth;
    }

    /**
     * 获取省id
     *
     * @return province - 省id
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省id
     *
     * @param province 省id
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取头像
     *
     * @return avatar - 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 设置头像
     *
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取区
     *
     * @return district - 区
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 设置区
     *
     * @param district 区
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * 获取地址
     *
     * @return address - 地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地址
     *
     * @param address 地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}