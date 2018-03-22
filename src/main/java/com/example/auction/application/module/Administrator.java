package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="administrator")
public class Administrator {
    @Id
    @GeneratedValue
    @Column(name="admin_id")
    private Long adminId;

    @Column(name="admin_name")
    private String adminName;

    @Column(name="tel_number")
    private String telNumber;

    @Column(name="email")
    private String email;

    @Column(name="regist_time")
    private Date registTime;

    @Column(name="password")
    private String password;

    @Column(name="admin_sign")
    private Byte isAdmin;

    @Column(name="is_delete")
    private Integer isDelete;

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegistTime() {
        return registTime;
    }

    public void setRegistTime(Date registTime) {
        this.registTime = registTime;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Byte isAdmin) {
        this.isAdmin = isAdmin;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "adminId=" + adminId +
                ", adminName='" + adminName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", email='" + email + '\'' +
                ", registTime=" + registTime +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                ", isDelete=" + isDelete +
                '}';
    }
}
