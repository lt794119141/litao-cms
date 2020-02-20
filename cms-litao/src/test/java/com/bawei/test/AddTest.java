package com.bawei.test;

import java.io.File;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bawei.utils.FileUtil;
import com.litao.cms.pojo.Article;
import com.litao.cms.service.RedisArticleService;

import scala.util.Random;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class AddTest {

	
	
	@Resource
	private RedisArticleService redisArticleService;
	
	@Test
	public void test() {
		File file = new File("D:\\1709DJsoup2");
		String[] list = file.list();
		for (String string : list) {
			String url="D:\\1709DJsoup2\\"+string;
			String content = FileUtil.readTextFileByLine(url);
			Article article = new Article();
			article.setTitle(string.replace(".txt",""));
			article.setContent(content);
			Random random = new Random();
			int nextInt = random.nextInt(7);
			article.setChannelId(nextInt);
			article.setHot(nextInt);
			article.setHits(nextInt);
			article.setUserId(199);
			article.setCategoryId(1);
			article.setStatus(1);
			article.setDeleted(0);
			article.setCommentcnt(0);
			
			redisArticleService.save(article);
			
		}
		
	}
}
