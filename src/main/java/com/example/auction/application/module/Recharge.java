package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="member_recharge")
public class Recharge {
    @Id
    @GeneratedValue
    private Long rechargeId;

    private Long userId;

    private Long money;

    private Date time;

    private Integer isDelete;

    private String nickName;

    private int num;

    private String telNumber;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Long getRechargeId() {
        return rechargeId;
    }

    public void setRechargeId(Long rechargeId) {
        this.rechargeId = rechargeId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Recharge{" +
                "rechargeId=" + rechargeId +
                ", userId=" + userId +
                ", money=" + money +
                ", time=" + time +
                ", isDelete=" + isDelete +
                ", nickName='" + nickName + '\'' +
                ", num=" + num +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
