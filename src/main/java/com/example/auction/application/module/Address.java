package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="order_address")
public class Address {
    @Id
    @GeneratedValue
    /**
     * 地址编号(id)
     * BIGINT
     */
    @Column(name="address_id")
    private Long addressId;

    /**
     * 用户id
     * BIGINT
     */
    @Column(name="user_id")
    private Long userId;

    /**
     * 用户姓名
     * VARCHAR
     */
    @Column(name="name")
    private String name;

    /**
     * 手机号码
     * VARCHAR
     */
    @Column(name="user_mobile")
    private String userMobile;

    /**
     * 用户地址
     * VARCHAR
     */
    @Column(name="address")
    private String address;

    /**
     * 用户详细地址
     * VARCHAR
     */
    @Column(name="detailedaddress")
    private String detailedaddress;

    /**
     * 是否默认地址
     * VARCHAR
     */
    @Column(name="sfdefault")
    private String sfdefault;

    /**
     * 创建日期
     * VARCHAR
     */
    @Column(name="creatime")
    private Date creatime;

    /**
     * 是否删除
     * VARCHAR
     */
    @Column(name="sfdelete")
    private Integer sfdelete;

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedaddress() {
        return detailedaddress;
    }

    public void setDetailedaddress(String detailedaddress) {
        this.detailedaddress = detailedaddress;
    }

    public String getSfdefault() {
        return sfdefault;
    }

    public void setSfdefault(String sfdefault) {
        this.sfdefault = sfdefault;
    }

    public Date getCreatime() {
        return creatime;
    }

    public void setCreatime(Date creatime) {
        this.creatime = creatime;
    }

    public Integer getSfdelete() {
        return sfdelete;
    }

    public void setSfdelete(Integer sfdelete) {
        this.sfdelete = sfdelete;
    }

    @Override
    public String toString() {
        return "Adress{" +
                "addressId=" + addressId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", address='" + address + '\'' +
                ", detailedaddress='" + detailedaddress + '\'' +
                ", sfdefault='" + sfdefault + '\'' +
                ", creatime=" + creatime +
                ", sfdelete='" + sfdelete + '\'' +
                '}';
    }
}
