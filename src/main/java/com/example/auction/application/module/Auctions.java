package com.example.auction.application.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="auctions")
public class Auctions {
    @Id
    @GeneratedValue

    private Long auctionId;

    private Long productId;

    private Long userId;

    private int num;

    private Date time;

    private Integer isDelete;

    private Long money;

    private String headimgUrl;

    private String nickName;

    private String telNumber;

    public Long getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Long auctionId) {
        this.auctionId = auctionId;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public String getHeadimgUrl() {
        return headimgUrl;
    }

    public void setHeadimgUrl(String headimgUrl) {
        this.headimgUrl = headimgUrl;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Auctions{" +
                "auctionId=" + auctionId +
                ", productId=" + productId +
                ", userId=" + userId +
                ", num=" + num +
                ", time=" + time +
                ", isDelete=" + isDelete +
                ", money=" + money +
                ", headimgUrl='" + headimgUrl + '\'' +
                ", nickName='" + nickName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                '}';
    }
}
