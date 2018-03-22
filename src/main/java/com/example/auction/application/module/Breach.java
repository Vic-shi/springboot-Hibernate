package com.example.auction.application.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="breach_table")
public class Breach {
    @Id
    @GeneratedValue
    private Long breachId;

    private Long userId;

    private Long productId;

    private Date time;

    private Integer isDelete;

    private String nickName;

    private int num;

    private String telNumber;

    public Long getBreachId() {
        return breachId;
    }

    public void setBreachId(Long breachId) {
        this.breachId = breachId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
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
        return "Breach{" +
                "breachId=" + breachId +
                ", userId=" + userId +
                ", productId=" + productId +
                ", time=" + time +
                ", isDelete=" + isDelete +
                ", nickName='" + nickName + '\'' +
                ", num=" + num +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
