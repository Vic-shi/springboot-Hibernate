package com.example.auction.application.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity(name="product_detail")
public class Product {

    private String id;

    public String getId() {
        return productId +"";
    }
    @Id
    /**
     * 作品id
     * BIGINT
     */
    @Column(name="product_id")
    private Long productId;
    /**
     * 作品名称
     * VARCHAR
     */
    @Column(name="product_name")
    private String productName;
    /**
     * 作品主图
     * VARCHAR
     */
    @Column(name="product_picture_main")
    private String productPictureMain;
    /**
     * 作品副图1
     * VARCHAR
     */
    @Column(name="product_picture_first")
    private String productPictureFirst;
    /**
     * 作品副图2
     * VARCHAR
     */
    @Column(name="product_picture_second")
    private String productPictureSecond;
    /**
     * 作品副图3
     * VARCHAR
     */
    @Column(name="product_picture_third")
    private String productPictureThird;
    /**
     * 作品主图描述
     * VARCHAR
     */
    @Column(name="product_picture_main_describe")
    private String productPictureMainDescribe;
    /**
     * 作品副图1描述
     * VARCHAR
     */
    @Column(name="product_picture_first_describe")
    private String productPictureFirstDescribe;
    /**
     * 作品副图2描述
     * VARCHAR
     */
    @Column(name="product_picture_second_describe")
    private String productPictureSecondDescribe;
    /**
     * 作品副图3描述
     * VARCHAR
     */
    @Column(name="product_picture_third_describe")
    private String productPictureThirdDescribe;
    /**
     * 作品尺寸
     * ENUM
     */
    @Column(name="product_size")
    private Integer productSize;
    /**
     * 作品押金
     * BIGINT
     */
    @Column(name="product_deposit")
    private Long productDeposit;
    /**
     * 作品简介
     * VARCHAR
     */
    @Column(name="product_profile")
    private String productProfile;
    /**
     * 作品创作时间
     * TIMESTAMP
     */
    @Column(name="product_create_time")
    private Date productCreateTime;
    /**
     * 作品录入时间
     * TIMESTAMP
     */
    @Column(name="product_input_time")
    private Date productInputTime;
    /**
     * 作品修改时间
     * TIMESTAMP
     */
    @Column(name="product_update_time")
    private Date productUpdateTime;
    /**
     * 作品状态
     * VARCHAR
     */
    @Column(name="product_status")
    private Integer productStatus;
    /**
     * 作品作者id
     * BIGINT
     */
    @Column(name="product_author_id")
    private Long productAuthorId;

    private Integer isDelete;

    /**
     * 拍卖结束时间
     */
    private Date productEndTime;
    /**
     * 初始价格
     */
    private Long productStartMoney;
    /**
     * 当前价格
     */
    private Long productNowMoney;
    /**
     * 结束价格
     */
    private Long productEndMoney;
    /**
     * 是否开始拍卖
     */
    private Integer isAuction;



    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPictureMain() {
        return productPictureMain;
    }

    public void setProductPictureMain(String productPictureMain) {
        this.productPictureMain = productPictureMain;
    }

    public String getProductPictureFirst() {
        return productPictureFirst;
    }

    public void setProductPictureFirst(String productPictureFirst) {
        this.productPictureFirst = productPictureFirst;
    }

    public String getProductPictureSecond() {
        return productPictureSecond;
    }

    public void setProductPictureSecond(String productPictureSecond) {
        this.productPictureSecond = productPictureSecond;
    }

    public String getProductPictureThird() {
        return productPictureThird;
    }

    public void setProductPictureThird(String productPictureThird) {
        this.productPictureThird = productPictureThird;
    }

    public String getProductPictureMainDescribe() {
        return productPictureMainDescribe;
    }

    public void setProductPictureMainDescribe(String productPictureMainDescribe) {
        this.productPictureMainDescribe = productPictureMainDescribe;
    }

    public String getProductPictureFirstDescribe() {
        return productPictureFirstDescribe;
    }

    public void setProductPictureFirstDescribe(String productPictureFirstDescribe) {
        this.productPictureFirstDescribe = productPictureFirstDescribe;
    }

    public String getProductPictureSecondDescribe() {
        return productPictureSecondDescribe;
    }

    public void setProductPictureSecondDescribe(String productPictureSecondDescribe) {
        this.productPictureSecondDescribe = productPictureSecondDescribe;
    }

    public String getProductPictureThirdDescribe() {
        return productPictureThirdDescribe;
    }

    public void setProductPictureThirdDescribe(String productPictureThirdDescribe) {
        this.productPictureThirdDescribe = productPictureThirdDescribe;
    }
    public Integer getProductSize() {
        return productSize;
    }

    public void setProductSize(Integer productSize) {
        this.productSize = productSize;
    }

    public Long getProductDeposit() {
        return productDeposit;
    }

    public void setProductDeposit(Long productDeposit) {
        this.productDeposit = productDeposit;
    }

    public String getProductProfile() {
        return productProfile;
    }

    public void setProductProfile(String productProfile) {
        this.productProfile = productProfile;
    }

    public Date getProductCreateTime() {
        return productCreateTime;
    }

    public void setProductCreateTime(Date productCreateTime) {
        this.productCreateTime = productCreateTime;
    }

    public Date getProductInputTime() {
        return productInputTime;
    }

    public void setProductInputTime(Date productInputTime) {
        this.productInputTime = productInputTime;
    }

    public Date getProductUpdateTime() {
        return productUpdateTime;
    }

    public void setProductUpdateTime(Date productUpdateTime) {
        this.productUpdateTime = productUpdateTime;
    }

    public Integer getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(Integer productStatus) {
        this.productStatus = productStatus;
    }

    public Long getProductAuthorId() {
        return productAuthorId;
    }

    public void setProductAuthorId(Long productAuthorId) {
        this.productAuthorId = productAuthorId;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getProductEndTime() {
        return productEndTime;
    }

    public void setProductEndTime(Date productEndTime) {
        this.productEndTime = productEndTime;
    }



    public Long getProductStartMoney() {
        return productStartMoney;
    }

    public void setProductStartMoney(Long productStartMoney) {
        this.productStartMoney = productStartMoney;
    }

    public Long getProductNowMoney() {
        return productNowMoney;
    }

    public void setProductNowMoney(Long productNowMoney) {
        this.productNowMoney = productNowMoney;
    }

    public Long getProductEndMoney() {
        return productEndMoney;
    }

    public void setProductEndMoney(Long productEndMoney) {
        this.productEndMoney = productEndMoney;
    }

    public Integer getIsAuction() {
        return isAuction;
    }

    public void setIsAuction(Integer isAuction) {
        this.isAuction = isAuction;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPictureMain='" + productPictureMain + '\'' +
                ", productPictureFirst='" + productPictureFirst + '\'' +
                ", productPictureSecond='" + productPictureSecond + '\'' +
                ", productPictureThird='" + productPictureThird + '\'' +
                ", productPictureMainDescribe='" + productPictureMainDescribe + '\'' +
                ", productPictureFirstDescribe='" + productPictureFirstDescribe + '\'' +
                ", productPictureSecondDescribe='" + productPictureSecondDescribe + '\'' +
                ", productPictureThirdDescribe='" + productPictureThirdDescribe + '\'' +
                ", productSize=" + productSize +
                ", productDeposit=" + productDeposit +
                ", productProfile='" + productProfile + '\'' +
                ", productCreateTime=" + productCreateTime +
                ", productInputTime=" + productInputTime +
                ", productUpdateTime=" + productUpdateTime +
                ", productStatus=" + productStatus +
                ", productAuthorId=" + productAuthorId +
                ", isDelete=" + isDelete +
                ", productEndTime=" + productEndTime +
                ", productStartMoney=" + productStartMoney +
                ", productNowMoney=" + productNowMoney +
                ", productEndMoney=" + productEndMoney +
                ", isAuction=" + isAuction +
                '}';
    }
}
