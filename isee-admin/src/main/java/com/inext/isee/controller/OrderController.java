/*
* 文 件 名:  OrderController
* 版    权:  Copyright (C) 2009-2016 Hangzhou 2Dfire Technology Co., Ltd. All rights reserved
* 描    述:  <描述>
* 修 改 人:  zhiliao
* 修改时间:  2017-04-17
* 跟踪单号:  <跟踪单号>
* 修改单号:  <修改单号>
* 修改内容:  <修改内容>
*/
package com.inext.isee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.inext.isee.entity.product.Order;

/**
 * OrderController
 *
 * @author zhiliao
 * @since 2017-04-17
 */
@Controller
@RequestMapping("/order")
public class OrderController
{
    @RequestMapping("/list")
    public String list(Model model)
    {
        return "pc/order-list";
    }
    
    @RequestMapping("/pre-add")
    String preAdd()
    {
        return "pc/order-add";
    }

    @RequestMapping("/create")
    public String create(@RequestParam("order") Order order)
    {
        return "pc/order-list";
    }
}