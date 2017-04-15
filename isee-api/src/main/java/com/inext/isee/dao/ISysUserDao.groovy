package com.inext.isee.dao

import com.inext.isee.entity.sys.SysUser
import org.springframework.stereotype.Repository

/**
 * IUserDao
 *
 * @author zhiliao
 * @since 2017-04-06
 */
@Repository
interface ISysUserDao {
    SysUser findByUserName(String userName)

    int create (SysUser sysUser)
}
