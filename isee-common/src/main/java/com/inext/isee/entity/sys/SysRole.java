package com.inext.isee.entity.sys;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * SysRole
 *
 * @author zhiliao
 * @since 2017-04-06
 */
@XmlRootElement(name = "sys_role")
public class SysRole {
    private int id;
    private String name;

    public SysRole() {
    }

    public SysRole(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
