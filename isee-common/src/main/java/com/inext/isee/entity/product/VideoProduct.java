package com.inext.isee.entity.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Value;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * VideoProduct
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "video_product")
public class VideoProduct {
    @JsonIgnore
    private int id;
    /**
     * 产品编号
     */
    private String productNo;
    /**
     * 标题
     */
    private String title;
    /**
     * 产品url
     */
    private String url;
    /**
     * 产品快照url
     */
    private String snapshotUrl;
    /**
     * 封面url
     */
    private String pictureUrl;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 默认的播放时间
     */
    private String defaultPlayTime = "5000";
    /**
     * 状态 1审核通过，0审核未通过
     */
    private String status = "1";
    /**
     * 是否开启二次确认 1是  0否
     */
    private String isSecondOpen = "1";

    public VideoProduct() {
    }

    public VideoProduct(String productNo, String title, String url, String pictureUrl) {
        this.productNo = productNo;
        this.title = title;
        this.url = url;
        this.pictureUrl = pictureUrl;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductNo() {
        return productNo;
    }

    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSnapshotUrl() {
        return snapshotUrl;
    }

    public void setSnapshotUrl(String snapshotUrl) {
        this.snapshotUrl = snapshotUrl;
    }

    public String getDefaultPlayTime() {
        return defaultPlayTime;
    }

    public void setDefaultPlayTime(String defaultPlayTime) {
        this.defaultPlayTime = defaultPlayTime;
    }

    public String getIsSecondOpen() {
        return isSecondOpen;
    }

    public void setIsSecondOpen(String isSecondOpen) {
        this.isSecondOpen = isSecondOpen;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
