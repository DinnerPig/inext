package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Comment
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "comment")
public class Comment {
    private int id;
    /**
     * 产品编号
     */
    private String  productNo;
    /**
     * 产品类型 1 视频，2 图片，3 小说
     */
    private String productType;
    /**
     * 评论者
     */
    private String observer;
    /**
     * 评论信息
     */
    private String comment;

    public Comment() {
    }

    public Comment(int id, String productNo, String productType, String observer, String comment) {
        this.id = id;
        this.productNo = productNo;
        this.productType = productType;
        this.observer = observer;
        this.comment = comment;
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

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
