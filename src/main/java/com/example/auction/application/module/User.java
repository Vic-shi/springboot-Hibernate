package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="User")
public class User {

    @Id
    @GeneratedValue
    /**
     * 用户ID Long
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 微信号 VARCHAR
     */
    @Column(name="wechat_id")
    private String wechatId;

    /**
     * 手机号 VARCHAR
     */
    @Column(name="tel_number")
    private String telNumber;

    /**
     * 头像地址 VARCHAR
     */
    @Column(name="avatar_address")
    private String avatarAddress;

    /**
     * 密码 VARCHAR
     */
    @Column(name="password")
    private String password;

    /**
     * 注册时间
     *
     * DATE
     */
    @Column(name="regist_time")
    private Date registTime;

    /**
     * 昵称
     *
     * VARCHAR
     */
    @Column(name="nick_name")
    private String nickName;

    /**
     * 用户的标识，对当前公众号唯一
     *
     * VARCHAR
     */
    @Column(name="open_id")
    private String openId;

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     *
     * TINYINT
     */
    @Column(name="sex")
    private Byte sex;

    /**
     * 用户所在城市
     *
     * VARCHAR
     */
    @Column(name="city")
    private String city;

    /**
     * 用户所在国家
     *
     * VARCHAR
     */
    @Column(name="country")
    private String country;

    /**
     * 用户所在省份
     *
     * VARCHAR
     */
    @Column(name="province")
    private String province;

    /**
     * 用户的语言，简体中文为zh_CN
     *
     * VARCHAR
     */
    @Column(name="language")
    private String language;

    /**
     * 用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间
     *
     * BIGINT
     */
    private Date subscribeTime;

    /**
     * 用户头像，最后一个数值代表正方形头像大小 （有0、46、64、96、132数值可选，0代表640*640正方形头像）
     * 用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     *
     * VARCHAR
     */
    private String headimgUrl;

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。多平台的唯一识别Id
     *
     * VARCHAR
     */
    private String unionId;

    /**
     * 公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注
     *
     * VARCHAR
     */
    private String remark;

    /**
     * 用户被打上的标签ID列表
     *
     * VARCHAR
     */
    private String tagidList;

    /**
     * 租赁次数
     *
     * INT
     */
    private Integer leasesNumber;

    /**
     * 结单次数
     *
     * INT
     */
    private Integer ordersNumber;

    /**
     * 逾期次数
     *
     * INT
     */
    private Integer overdueNumber;

    /**
     * 账户余额 BIGINT
     */
    private Long accountBalance;

    private Integer isDelete;

    private String VerificationCode;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getWechatId() {
        return wechatId;
    }

    public void setWechatId(String wechatId) {
        this.wechatId = wechatId;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getAvatarAddress() {
        return avatarAddress;
    }

    public void setAvatarAddress(String avatarAddress) {
        this.avatarAddress = avatarAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Date getSubscribeTime() {
        return subscribeTime;
    }

    public void setSubscribeTime(Date subscribeTime) {
        this.subscribeTime = subscribeTime;
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
    }

    public String getUnionId() {
        return unionId;
    }

    public void setUnionId(String unionId) {
        this.unionId = unionId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getTagidList() {
        return tagidList;
    }

    public void setTagidList(String tagidList) {
        this.tagidList = tagidList;
    }

    public Integer getLeasesNumber() {
        return leasesNumber;
    }

    public void setLeasesNumber(Integer leasesNumber) {
        this.leasesNumber = leasesNumber;
    }

    public Integer getOrdersNumber() {
        return ordersNumber;
    }

    public void setOrdersNumber(Integer ordersNumber) {
        this.ordersNumber = ordersNumber;
    }

    public Integer getOverdueNumber() {
        return overdueNumber;
    }

    public void setOverdueNumber(Integer overdueNumber) {
        this.overdueNumber = overdueNumber;
    }

    public Long getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getVerificationCode() {
        return VerificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        VerificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", wechatId='" + wechatId + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", avatarAddress='" + avatarAddress + '\'' +
                ", password='" + password + '\'' +
                ", registTime=" + registTime +
                ", nickName='" + nickName + '\'' +
                ", openId='" + openId + '\'' +
                ", sex=" + sex +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", province='" + province + '\'' +
                ", language='" + language + '\'' +
                ", subscribeTime=" + subscribeTime +
                ", headimgUrl='" + headimgUrl + '\'' +
                ", unionId='" + unionId + '\'' +
                ", remark='" + remark + '\'' +
                ", tagidList='" + tagidList + '\'' +
                ", leasesNumber=" + leasesNumber +
                ", ordersNumber=" + ordersNumber +
                ", overdueNumber=" + overdueNumber +
                ", accountBalance=" + accountBalance +
                ", isDelete=" + isDelete +
                ", VerificationCode='" + VerificationCode + '\'' +
                '}';
    }
}
