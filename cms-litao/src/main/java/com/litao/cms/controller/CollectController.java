package com.litao.cms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bawei.utils.StringUtil;
import com.litao.cms.common.JsonResult;
import com.litao.cms.pojo.Article;
import com.litao.cms.service.ArticleService;
import com.litao.cms.service.CollectService;

@Controller
@RequestMapping("/collect/")
public class CollectController {
	
	@Autowired
	private CollectService collectService;
	
	
	
	
	@RequestMapping("delByIds")
	public @ResponseBody JsonResult delByIds(String ids) {
		System.out.println("++++++++"+"进入 CollectController");
		
		if(ids==null) {
			return JsonResult.fail(10001, "请选择删除的文章");
		}
		//删除
		boolean result = collectService.delByIds(ids);
		if(result) {
			return JsonResult.sucess();
		}
		return JsonResult.fail(500, "未知错误");
	}
	//保存
	@RequestMapping("collecting")
	public String  collecting(String url) {
		
		if(StringUtil.isHttpUrl1(url)) {
			String[] split = url.split("id");
		}
		
		
		
		return "redirect:/article/.html";
	}
	
}
