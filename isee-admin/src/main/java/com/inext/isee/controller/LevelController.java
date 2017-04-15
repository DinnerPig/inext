/*
* 文 件 名:  LevelController
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-12
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.controller;

import com.inext.isee.entity.product.Level;
import com.inext.isee.service.LevelService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * LevelController
 *
 * @author zhiliao
 * @since 2017-04-12
 */
@Controller
@RequestMapping("/level")
public class LevelController {

    @Resource
    LevelService levelService;

    @RequestMapping("list")
    public String getLevelList(Model model) {
        List<Level> list = levelService.getLevelList();
        model.addAttribute("levelList", list);
        return "pc/level";
    }
}