package com.litao.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.litao.cms.service.UserService;

/**   
* @Title: UserController.java 
* @Package com.wenjiaquan.cms.controller.User 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2019年12月10日 下午6:23:11 
* @version V1.0   
*/
@Controller
@RequestMapping("/")
public class IndexController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
}
