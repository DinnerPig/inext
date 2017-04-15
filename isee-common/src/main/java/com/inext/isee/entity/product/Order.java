package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Order
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "order")
public class Order {
    private int id;
    /**
     * 设备编号
     */
    private String terminalNo;
    /**
     * 产品编号
     */
    private String productNo;
    /**
     * 产品类型 1 视频，2 图片，3 小说
     */
    private String productType;
    /**
     * 产品描述
     */
    private String productDesc;
    /**
     * 订单原始价格
     */
    private String originAmount;
    /**
     * 实际收入
     */
    private String actualIncome;
    /**
     * 通道费
     */
    private String channelFee;
    /**
     * 通道费率
     */
    private String channelRate;
    /**
     * 订单创建时间
     */
    private String createTime;
    /**
     * 订单支付时间
     */
    private String payTime;
    /**
     * 支付状态
     */
    private String payStatus;
    /**
     * 支付状态描述
     */
    private String payStatusDesc;
    /**
     * 支付版本号
     */
    private String payVersion;
    /**
     * SDK版本号
     */
    private String sdkVersion;
    /**
     * 应用包名
     */
    private String packageName;

    public Order() {
    }

    public Order(int id, String terminalNo, String productNo, String productType, String productDesc, String originAmount, String actualIncome, String channelFee, String channelRate, String createTime, String payTime, String payStatus, String payStatusDesc, String payVersion, String sdkVersion, String packageName) {
        this.id = id;
        this.terminalNo = terminalNo;
        this.productNo = productNo;
        this.productType = productType;
        this.productDesc = productDesc;
        this.originAmount = originAmount;
        this.actualIncome = actualIncome;
        this.channelFee = channelFee;
        this.channelRate = channelRate;
        this.createTime = createTime;
        this.payTime = payTime;
        this.payStatus = payStatus;
        this.payStatusDesc = payStatusDesc;
        this.payVersion = payVersion;
        this.sdkVersion = sdkVersion;
        this.packageName = packageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTerminalNo() {
        return terminalNo;
    }

    public void setTerminalNo(String terminalNo) {
        this.terminalNo = terminalNo;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

    public String getOriginAmount() {
        return originAmount;
    }

    public void setOriginAmount(String originAmount) {
        this.originAmount = originAmount;
    }

    public String getActualIncome() {
        return actualIncome;
    }

    public void setActualIncome(String actualIncome) {
        this.actualIncome = actualIncome;
    }

    public String getChannelFee() {
        return channelFee;
    }

    public void setChannelFee(String channelFee) {
        this.channelFee = channelFee;
    }

    public String getChannelRate() {
        return channelRate;
    }

    public void setChannelRate(String channelRate) {
        this.channelRate = channelRate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayStatusDesc() {
        return payStatusDesc;
    }

    public void setPayStatusDesc(String payStatusDesc) {
        this.payStatusDesc = payStatusDesc;
    }

    public String getPayVersion() {
        return payVersion;
    }

    public void setPayVersion(String payVersion) {
        this.payVersion = payVersion;
    }

    public String getSdkVersion() {
        return sdkVersion;
    }

    public void setSdkVersion(String sdkVersion) {
        this.sdkVersion = sdkVersion;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }
}
