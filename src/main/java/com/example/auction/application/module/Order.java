package com.example.auction.application.module;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

/**
 * 订单明细模型
 * 查看明细使用
 * @author dzj
 *
*/
@Entity(name="order_detail")
public class Order{
    private String id;

    public String getId() {
        return orderId+"";
    }

    @Id
/**
 * 订单编号
 * BIGINT
 */
private Long orderId;

/**
 * 订单类型
 * TINYINT
 */
private Integer orderType;

/**
 * 订单创建时间
 * TIMESTAMP
 */
private Date orderCreateTime;

/**
 * 订单支付时间
 * TIMESTAMP
 */
private Date orderPayTime;

/**
 * 发货时间
 * TIMESTAMP
 */
private Date orderSendTime;

/**
 * 订单状态
 * TINYINT
 */
private Integer orderStatus;

/**
 * 订单总价
 * Long
 */
private Long orderTotalValue;

/**
 * 快递费用
 * Long
 */
private Long orderPostage;

/**
 * 优惠
 * Long
 */
private Long preferential;

/**
 * 实际付款
 * Long
 */
private Long actualPayment;


/**
 * 作品押金
 * Long
 */
private Long productDeposit;

/**
 * 作品装裱价格
 * Long
 */
private Long productMountedValue;

/**
 * 运单编号
 * BIGINT
 */
private Long waybillNo;

/**
 * 承运公司
 * VARCHAR
 */
private String carrierCompany;

/**
 * 用户id
 * BIGINT
 */
private Long userId;

/**
 * 订单修改时间
 * TIMESTAMP
 */
private Date orderUpdateTime;

/**
 * 确认收货时间
 * TIMESTAMP
 */
private Date orderComfirmTime;

/**
 * 作品归还日期
 * TIMESTAMP
 */
private Date returnProductTime;

/**
 * 总期限
 * INTEGER
 */
private Integer totalTerm;

/**
 * 期限类型
 * INTEGER
 */
private Integer term;

/**
 * 是否逾期（0:未逾期，1：已逾期）
 * Boolean
 */
private Integer isOverdue;

/**
 * 原作品id
 * LONG
 */
private Long productId;

/**
 * 结单时间
 * TIMESTAMP
 */
private Date overOrderTime;

/**
 * 用户名
 * VARCHAR
 */
private String userName;

/**
 * 用户手机号
 * VARCHAR
 */
private String userMobile;

/**
 * 用户地址
 * VARCHAR
 */
private String userAddress;

/**
 * 用户详细地址
 * VARCHAR
 */
private String userDetailAddress;

/**
 * 原作品图片
 * VARCHAR
 */
private String productPicture;

/**
 * 原作品名字
 * VARCHAR
 */
private String productName;

/**
 * 原作品作者
 * VARCHAR
 */
private String productAuthor;

/**
 * 租金
 * Long
 */
private Long rent;

/**
 * 订单修改员工
 */
private Long orderUpdateStaff;

/**
 * 结单原因:""：0：收藏此画1:转赠他人 2:遗失此画 3: 其他原因
 * VARCHAR
 */
private Integer adjustReason;

/**
 * 用户地址id
 */
private Long userAddressId;

/**
 * 作品作者id
 */
private Long productAuthorId;

/**
 * 公司地址id
 */
private Long companyAddressId;

/**
 * 还画照片1
 */
private String returnPictueFirst;

/**
 * 还画照片2
 */
private String returnPictueSecond;

/**
 * 还画照片3
 */
private String returnPictueThird;

/**
 * 定损后归还余额
 */
private Long returnMoney;

/**
 * 定损备注
 */
private String returnMoneyRemark;

/**
 * 是否线上购买
 */
private Integer isOnline;

/**
 * 作品尺寸
 */
private Integer productSize;

/**
 * 作品装裱状态
 */
private Integer productMountedStatus;

/**
 * 作品风格
 */
private Integer productStyle;

/**
 * 作品类型
 */
private Integer productType;

/**
 * 结单费用
 */
private Long overOrderCost;

/**
 * 作品市场价格
 * INT
 */
private Long productMarketValue;

/**
 * 订单剩余时间
 */
private Date orderDueTime;

/**
 * 服务器时间
 */
private Date serviceTime;


    private String nickName;
    private String telNumber;

    private Integer isDelete;
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Date getOrderCreateTime() {
        return orderCreateTime;
    }

    public void setOrderCreateTime(Date orderCreateTime) {
        this.orderCreateTime = orderCreateTime;
    }

    public Date getOrderPayTime() {
        return orderPayTime;
    }

    public void setOrderPayTime(Date orderPayTime) {
        this.orderPayTime = orderPayTime;
    }

    public Date getOrderSendTime() {
        return orderSendTime;
    }

    public void setOrderSendTime(Date orderSendTime) {
        this.orderSendTime = orderSendTime;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Long getOrderTotalValue() {
        return orderTotalValue;
    }

    public void setOrderTotalValue(Long orderTotalValue) {
        this.orderTotalValue = orderTotalValue;
    }

    public Long getOrderPostage() {
        return orderPostage;
    }

    public void setOrderPostage(Long orderPostage) {
        this.orderPostage = orderPostage;
    }

    public Long getPreferential() {
        return preferential;
    }

    public void setPreferential(Long preferential) {
        this.preferential = preferential;
    }

    public Long getActualPayment() {
        return actualPayment;
    }

    public void setActualPayment(Long actualPayment) {
        this.actualPayment = actualPayment;
    }

    public Long getProductDeposit() {
        return productDeposit;
    }

    public void setProductDeposit(Long productDeposit) {
        this.productDeposit = productDeposit;
    }

    public Long getProductMountedValue() {
        return productMountedValue;
    }

    public void setProductMountedValue(Long productMountedValue) {
        this.productMountedValue = productMountedValue;
    }

    public Long getWaybillNo() {
        return waybillNo;
    }

    public void setWaybillNo(Long waybillNo) {
        this.waybillNo = waybillNo;
    }

    public String getCarrierCompany() {
        return carrierCompany;
    }

    public void setCarrierCompany(String carrierCompany) {
        this.carrierCompany = carrierCompany;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getOrderUpdateTime() {
        return orderUpdateTime;
    }

    public void setOrderUpdateTime(Date orderUpdateTime) {
        this.orderUpdateTime = orderUpdateTime;
    }

    public Date getOrderComfirmTime() {
        return orderComfirmTime;
    }

    public void setOrderComfirmTime(Date orderComfirmTime) {
        this.orderComfirmTime = orderComfirmTime;
    }

    public Date getReturnProductTime() {
        return returnProductTime;
    }

    public void setReturnProductTime(Date returnProductTime) {
        this.returnProductTime = returnProductTime;
    }

    public Integer getTotalTerm() {
        return totalTerm;
    }

    public void setTotalTerm(Integer totalTerm) {
        this.totalTerm = totalTerm;
    }

    public Integer getTerm() {
        return term;
    }

    public void setTerm(Integer term) {
        this.term = term;
    }

    public Integer getIsOverdue() {
        return isOverdue;
    }

    public void setIsOverdue(Integer isOverdue) {
        this.isOverdue = isOverdue;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Date getOverOrderTime() {
        return overOrderTime;
    }

    public void setOverOrderTime(Date overOrderTime) {
        this.overOrderTime = overOrderTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserDetailAddress() {
        return userDetailAddress;
    }

    public void setUserDetailAddress(String userDetailAddress) {
        this.userDetailAddress = userDetailAddress;
    }

    public String getProductPicture() {
        return productPicture;
    }

    public void setProductPicture(String productPicture) {
        this.productPicture = productPicture;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductAuthor() {
        return productAuthor;
    }

    public void setProductAuthor(String productAuthor) {
        this.productAuthor = productAuthor;
    }

    public Long getRent() {
        return rent;
    }

    public void setRent(Long rent) {
        this.rent = rent;
    }

    public Long getOrderUpdateStaff() {
        return orderUpdateStaff;
    }

    public void setOrderUpdateStaff(Long orderUpdateStaff) {
        this.orderUpdateStaff = orderUpdateStaff;
    }

    public Integer getAdjustReason() {
        return adjustReason;
    }

    public void setAdjustReason(Integer adjustReason) {
        this.adjustReason = adjustReason;
    }

    public Long getUserAddressId() {
        return userAddressId;
    }

    public void setUserAddressId(Long userAddressId) {
        this.userAddressId = userAddressId;
    }

    public Long getProductAuthorId() {
        return productAuthorId;
    }

    public void setProductAuthorId(Long productAuthorId) {
        this.productAuthorId = productAuthorId;
    }

    public Long getCompanyAddressId() {
        return companyAddressId;
    }

    public void setCompanyAddressId(Long companyAddressId) {
        this.companyAddressId = companyAddressId;
    }

    public String getReturnPictueFirst() {
        return returnPictueFirst;
    }

    public void setReturnPictueFirst(String returnPictueFirst) {
        this.returnPictueFirst = returnPictueFirst;
    }

    public String getReturnPictueSecond() {
        return returnPictueSecond;
    }

    public void setReturnPictueSecond(String returnPictueSecond) {
        this.returnPictueSecond = returnPictueSecond;
    }

    public String getReturnPictueThird() {
        return returnPictueThird;
    }

    public void setReturnPictueThird(String returnPictueThird) {
        this.returnPictueThird = returnPictueThird;
    }

    public Long getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Long returnMoney) {
        this.returnMoney = returnMoney;
    }

    public String getReturnMoneyRemark() {
        return returnMoneyRemark;
    }

    public void setReturnMoneyRemark(String returnMoneyRemark) {
        this.returnMoneyRemark = returnMoneyRemark;
    }

    public Integer getIsOnline() {
        return isOnline;
    }

    public void setIsOnline(Integer isOnline) {
        this.isOnline = isOnline;
    }

    public Integer getProductSize() {
        return productSize;
    }

    public void setProductSize(Integer productSize) {
        this.productSize = productSize;
    }

    public Integer getProductMountedStatus() {
        return productMountedStatus;
    }

    public void setProductMountedStatus(Integer productMountedStatus) {
        this.productMountedStatus = productMountedStatus;
    }

    public Integer getProductStyle() {
        return productStyle;
    }

    public void setProductStyle(Integer productStyle) {
        this.productStyle = productStyle;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Long getOverOrderCost() {
        return overOrderCost;
    }

    public void setOverOrderCost(Long overOrderCost) {
        this.overOrderCost = overOrderCost;
    }

    public Long getProductMarketValue() {
        return productMarketValue;
    }

    public void setProductMarketValue(Long productMarketValue) {
        this.productMarketValue = productMarketValue;
    }

    public Date getOrderDueTime() {
        return orderDueTime;
    }

    public void setOrderDueTime(Date orderDueTime) {
        this.orderDueTime = orderDueTime;
    }

    public Date getServiceTime() {
        return serviceTime;
    }

    public void setServiceTime(Date serviceTime) {
        this.serviceTime = serviceTime;
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

    public String getTelNumber() {
        return telNumber;
    }

    public void setTelNumber(String telNumber) {
        this.telNumber = telNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderId=" + orderId +
                ", orderType=" + orderType +
                ", orderCreateTime=" + orderCreateTime +
                ", orderPayTime=" + orderPayTime +
                ", orderSendTime=" + orderSendTime +
                ", orderStatus=" + orderStatus +
                ", orderTotalValue=" + orderTotalValue +
                ", orderPostage=" + orderPostage +
                ", preferential=" + preferential +
                ", actualPayment=" + actualPayment +
                ", productDeposit=" + productDeposit +
                ", productMountedValue=" + productMountedValue +
                ", waybillNo=" + waybillNo +
                ", carrierCompany='" + carrierCompany + '\'' +
                ", userId=" + userId +
                ", orderUpdateTime=" + orderUpdateTime +
                ", orderComfirmTime=" + orderComfirmTime +
                ", returnProductTime=" + returnProductTime +
                ", totalTerm=" + totalTerm +
                ", term=" + term +
                ", isOverdue=" + isOverdue +
                ", productId=" + productId +
                ", overOrderTime=" + overOrderTime +
                ", userName='" + userName + '\'' +
                ", userMobile='" + userMobile + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", userDetailAddress='" + userDetailAddress + '\'' +
                ", productPicture='" + productPicture + '\'' +
                ", productName='" + productName + '\'' +
                ", productAuthor='" + productAuthor + '\'' +
                ", rent=" + rent +
                ", orderUpdateStaff=" + orderUpdateStaff +
                ", adjustReason=" + adjustReason +
                ", userAddressId=" + userAddressId +
                ", productAuthorId=" + productAuthorId +
                ", companyAddressId=" + companyAddressId +
                ", returnPictueFirst='" + returnPictueFirst + '\'' +
                ", returnPictueSecond='" + returnPictueSecond + '\'' +
                ", returnPictueThird='" + returnPictueThird + '\'' +
                ", returnMoney=" + returnMoney +
                ", returnMoneyRemark='" + returnMoneyRemark + '\'' +
                ", isOnline=" + isOnline +
                ", productSize=" + productSize +
                ", productMountedStatus=" + productMountedStatus +
                ", productStyle=" + productStyle +
                ", productType=" + productType +
                ", overOrderCost=" + overOrderCost +
                ", productMarketValue=" + productMarketValue +
                ", orderDueTime=" + orderDueTime +
                ", serviceTime=" + serviceTime +
                ", nickName='" + nickName + '\'' +
                ", telNumber='" + telNumber + '\'' +
                ", isDelete=" + isDelete +
                '}';
    }
}
