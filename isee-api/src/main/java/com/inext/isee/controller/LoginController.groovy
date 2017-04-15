package com.inext.isee.controller

import com.inext.isee.entity.sys.SysUser
import org.springframework.security.core.annotation.AuthenticationPrincipal
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody

/**
 * LoginController
 *
 * @author zhiliao
 * @since 2017-04-07
 */
//@Controller
class LoginController {

    /**
     * 用户名密码是用base64 加密 原文为 admin:admin 即 用户名:密码  内容是放在request.getHeader 的 "authorization" 中
     *
     * @param loginedUser
     * @param logout
     * @return
     */
    @RequestMapping(value = "/login")
    @ResponseBody
    Object login(@AuthenticationPrincipal SysUser loginedUser, @RequestParam(name = "logout", required = false) String logout) {
        if (logout != null) {
            null;
        }
        if (loginedUser != null) {
            loginedUser;
        }
        null;
    }
}
