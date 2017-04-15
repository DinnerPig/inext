/*
* 文 件 名:  MemberService
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-12
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.service;

import com.inext.isee.dao.IMemberDao;
import com.inext.isee.entity.product.Member;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * MemberService
 *
 * @author zhiliao
 * @since 2017-04-12
 */
@Service
public class MemberService {
    @Resource
    IMemberDao memberDao;

    public List<Member> getMemberList() {
        return memberDao.getMemberList();
    }
}