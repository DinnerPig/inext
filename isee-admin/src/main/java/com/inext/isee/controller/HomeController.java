/*
 * Copyright 2010-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.inext.isee.controller;

import com.inext.isee.entity.sys.SysUser;
import com.inext.isee.service.SysUserService;
import com.inext.isee.vo.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 在 @PreAuthorize 中我们可以利用内建的 SPEL 表达式：比如 'hasRole()' 来决定哪些用户有权访问。
 * 需注意的一点是 hasRole 表达式认为每个角色名字前都有一个前缀 'ROLE_'。所以这里的 'ADMIN' 其实在
 * 数据库中存储的是 'ROLE_ADMIN' 。这个 @PreAuthorize 可以修饰Controller也可修饰Controller中的方法。
 **/

@Controller
@RequestMapping("/users")
@PreAuthorize("hasRole('ADMIN')")
public class HomeController {

	/**
	 * Show the home page to the user. This controller renders a different version of the
	 * home view for normal, mobile and tablet browsers.
	 */
	@RequestMapping("/")
	String home(Model model) {
		//return "home";
		Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
		model.addAttribute("msg", msg);
		return  "home";
	}

	@Autowired
	SysUserService sysUserService;

	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public String getUsers() {
		return "getUsers";
	}

	@Secured({"ROLE_ADMIN","ROLE_USER"})//此方法只允许 ROLE_ADMIN 和ROLE_USER 角色 访问
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody SysUser user) {
		return  sysUserService.create(user);
	}


	@Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public String update() {
		return "updateUser";
	}

	@Secured("ROLE_ADMIN")//此方法只允许 ROLE_ADMIN 角色访问
	@RequestMapping(method = RequestMethod.DELETE)
	@ResponseBody
	public String delete() {
		return "deleteUser";
	}

}
