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

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the About page.
 * 
 * @author Roy Clarkson
 */
@Controller
public class AboutController {

	/**
	 * Show the About page to the user. This controller renders a different version of the
	 * about view for normal, mobile, and tablet browsers.
	 */
	@RequestMapping("/about")
	public String home() {
		return "about";
	}

	@RequestMapping("/helloFtl")
	public String helloFtl(Model model) {
		model.addAttribute("hello", "Hello zhiliao freemarker !");
		return "hello";
	}

	@RequestMapping("/helloHtml")
	public String helloHtml(Model model) {
		model.addAttribute("hello", "Hello zhiliao thymelef!");
		return "hello";
	}
}
