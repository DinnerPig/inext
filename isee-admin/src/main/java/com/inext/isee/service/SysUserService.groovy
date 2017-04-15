package com.inext.isee.service

import com.inext.isee.dao.ISysUserDao
import com.inext.isee.entity.sys.SysUser
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

import javax.annotation.Resource

/**
 * SysUserService
 *
 * @author zhiliao
 * @since 2017-04-06
 */
@Service
class SysUserService {
    @Resource
    ISysUserDao sysUserDao

    SysUser findByUserName(String userName) {
        sysUserDao.findByUserName(userName)
    }

    SysUser create(SysUser sysUser){
        //进行加密
        BCryptPasswordEncoder encoder =new BCryptPasswordEncoder();
        sysUser.setPassword(encoder.encode(sysUser.getPassword().trim()));
        sysUserDao.create(sysUser);
        return sysUser;
    }
}
