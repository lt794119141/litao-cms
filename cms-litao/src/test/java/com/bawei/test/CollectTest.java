package com.bawei.test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.litao.cms.controller.ArticleController;
import com.litao.cms.pojo.Collect;
import com.litao.cms.service.CollectService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class CollectTest {

	@Autowired
	private ArticleController articleController;
	
	@Autowired
	private CollectService collectService;
	
	@Test
	public void test() {
		//收藏
		//删除
		boolean delByIds = collectService.delByIds("26");
		System.out.println(delByIds);
		
		//查询
//		PageInfo<Collect> pageInfo = collectService.getPageInfo(199, 1, 3);
//		List<Collect> list = pageInfo.getList();
//		for (Collect collect : list) {
//			System.out.println(collect);
//		}
		
		
	}
}
