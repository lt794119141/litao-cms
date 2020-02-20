package com.bawei.test;

import java.io.File;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.bawei.utils.FileUtil;
import com.bawei.utils.StringUtil;
import com.google.gson.Gson;
import com.litao.cms.pojo.Article;
import com.litao.cms.service.ArticleService;
import com.sun.org.apache.bcel.internal.generic.IADD;

import kafka.utils.Json;
import scala.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class FileTest {

	
	
	@Autowired
	private KafkaTemplate<String, String> template;
	
	@Test
	public void test() {
		File file = new File("D:\\1709DJsoup2");
		String[] list = file.list();
		Article article = new Article();
		for (String string : list) {
			article.setTitle(string);
			String fileName="D:\\1709DJsoup2\\"+string;
			String readTextFileByLine = FileUtil.readTextFileByLine(fileName);
			article.setContent(readTextFileByLine);
			
			article.setChannelId(1);
			article.setCategoryId(28);
			article.setUserId(179);
			article.setHits(0);
			article.setHot(20);
			article.setStatus(1);
			article.setDeleted(0);
			article.setCommentcnt(0);
			
			System.out.println(article);
			
			String json = JSON.toJSONString(article);
			
			
			//template.sendDefault(g.toJson(article));
			
		template.sendDefault("article", json);
		}
		
//		List<String> readTextFileOfList = FileUtil.readTextFileOfList("D:\\1709DJsoup2\\“政法老兵”到位！上海市市长应勇任湖北省委书记.txt");
//		for (String string : readTextFileOfList) {
//			System.out.println(string);
//		}
	}
}
