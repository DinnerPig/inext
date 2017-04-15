package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * PictureProduct
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "picture_product")
public class PictureProduct {
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
     * 产品url 产品详情url 请求后随机产生指定个数的产品列表
     */
    private String url;
    /**
     * 缩略图url
     */
    private String snapshotUrl;

    public PictureProduct() {
    }

    public PictureProduct(int id, String productNo, String title, String url, String snapshotUrl) {
        this.id = id;
        this.productNo = productNo;
        this.title = title;
        this.url = url;
        this.snapshotUrl = snapshotUrl;
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
}
