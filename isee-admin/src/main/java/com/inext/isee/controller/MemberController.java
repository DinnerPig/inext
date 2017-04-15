/*
* 文 件 名:  MemberController
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-12
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.controller;

import com.inext.isee.entity.product.Member;
import com.inext.isee.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * MemberController
 *
 * @author zhiliao
 * @since 2017-04-12
 */
@Controller
@RequestMapping("/member")
public class MemberController {
    @Resource
    MemberService memberService;

    @RequestMapping("/list")
    public String getMemberList(Model model) {
        List<Member> list = memberService.getMemberList();
        model.addAttribute("memberList", list);
        return "pc/member";
    }
}