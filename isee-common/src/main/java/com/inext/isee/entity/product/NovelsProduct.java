package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * NovelsProduct
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "novels_product")
public class NovelsProduct {
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
     * 等级
     */
    private String level;
    /**
     * 不同等级对应的试读章节
     */
    private String tryChapter;

    public NovelsProduct() {
    }

    public NovelsProduct(int id, String productNo, String title, String url, String level, String tryChapter) {
        this.id = id;
        this.productNo = productNo;
        this.title = title;
        this.url = url;
        this.level = level;
        this.tryChapter = tryChapter;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getTryChapter() {
        return tryChapter;
    }

    public void setTryChapter(String tryChapter) {
        this.tryChapter = tryChapter;
    }
}
