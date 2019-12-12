package com.litao.cms.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**   
* @Title: AdminController.java 
* @Package com.wenjiaquan.cms.controller.admin 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2019年12月11日 下午6:22:18 
* @version V1.0   
*/
@Controller
@RequestMapping("/admin/")
public class AdminController {
	@RequestMapping("/")
	public String login() {
		return "admin/login";
	}
	
	@RequestMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	@RequestMapping("/user")
	public String user() {
		return "admin/user";
	}
}
