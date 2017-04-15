package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Version
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "version")
public class Version {
    private int id;
    /**
     * 产品版本号
     */
    private String productVersion;
    /**
     * 支付版本号
     */
    private String payVersion;
    /**
     * 更新方式 0 选择更新，1 强制更新
     */
    private String updateType;
    /**
     * 更新地址
     */
    private String updateUrl;
    /**
     * 界面切换标记
     */
    private String isSwitch;

    public Version() {
    }

    public Version(int id, String productVersion, String payVersion, String updateType, String updateUrl, String isSwitch) {
        this.id = id;
        this.productVersion = productVersion;
        this.payVersion = payVersion;
        this.updateType = updateType;
        this.updateUrl = updateUrl;
        this.isSwitch = isSwitch;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductVersion() {
        return productVersion;
    }

    public void setProductVersion(String productVersion) {
        this.productVersion = productVersion;
    }

    public String getPayVersion() {
        return payVersion;
    }

    public void setPayVersion(String payVersion) {
        this.payVersion = payVersion;
    }

    public String getUpdateType() {
        return updateType;
    }

    public void setUpdateType(String updateType) {
        this.updateType = updateType;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getIsSwitch() {
        return isSwitch;
    }

    public void setIsSwitch(String isSwitch) {
        this.isSwitch = isSwitch;
    }
}
