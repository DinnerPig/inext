package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Level
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "level")
public class Level {
    private int id;
    /**
     * 会员等级
     */
    private String level;
    /**
     * 等级类型 不同的等级类型  同等级价格不一样
     * 1 视频，2 图片，3 小说
     */
    private String levelType;
    /**
     * 等级价格
     */
    private int price;
    /**
     * 等级描述
     */
    private String desc;


    public Level() {
    }

    public Level(int id, String level, String levelType, int price, String desc) {
        this.id = id;
        this.level = level;
        this.levelType = levelType;
        this.price = price;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelType() {
        return levelType;
    }

    public void setLevelType(String levelType) {
        this.levelType = levelType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
