package com.inext.isee.entity.sys;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * SysRoleUser
 *
 * @author zhiliao
 * @since 2017-04-06
 */
@XmlRootElement(name = "sys_role_user")
public class SysRoleUser {
    private int id;
    private int sysUserId;
    private int SysRoleId;

    public SysRoleUser() {
    }

    public SysRoleUser(int id, int sysUserId, int sysRoleId) {
        this.id = id;
        this.sysUserId = sysUserId;
        SysRoleId = sysRoleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(int sysUserId) {
        this.sysUserId = sysUserId;
    }

    public int getSysRoleId() {
        return SysRoleId;
    }

    public void setSysRoleId(int sysRoleId) {
        SysRoleId = sysRoleId;
    }
}
