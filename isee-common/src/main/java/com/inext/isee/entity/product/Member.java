package com.inext.isee.entity.product;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Member
 *
 * @author zhiliao
 * @since 2017-04-05
 */
@XmlRootElement(name = "member")
public class Member {
    private int id;
    /**
     * 设备编号
     */
    private String terminalNo;
    /**
     * 等级
     */
    private String level;
    /**
     * 等级类型 1 视频，2 图片，3 小说
     */
    private String levelType;
    /**
     * 等级描述
     */
    private String levelDesc;

    public Member() {
    }

    public Member(int id, String terminalNo, String level, String levelType, String levelDesc) {
        this.id = id;
        this.terminalNo = terminalNo;
        this.level = level;
        this.levelType = levelType;
        this.levelDesc = levelDesc;
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

    public String getLevelDesc() {
        return levelDesc;
    }

    public void setLevelDesc(String levelDesc) {
        this.levelDesc = levelDesc;
    }
}
