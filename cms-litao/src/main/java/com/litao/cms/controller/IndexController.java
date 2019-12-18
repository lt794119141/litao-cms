package com.litao.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping("")
	public String index() {
		return "index";
	}
	
	
	@RequestMapping("/{channelId}/{cateId}.html")
	public String channel(@PathVariable Integer channelId,@PathVariable Integer cateId) {
		return "index";
	}
	
	@RequestMapping("article/{id}.html")
	public String articleDetail(@PathVariable Integer id) {
		return "article/detail";
	}
	
}
