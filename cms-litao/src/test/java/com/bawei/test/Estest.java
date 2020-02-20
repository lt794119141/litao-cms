package com.bawei.test;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.litao.cms.dao.ArticleRepository;
import com.litao.cms.pojo.Article;
import com.litao.cms.service.ArticleService;
import com.litao.cms.util.HLUtils;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class Estest {
	
	@Autowired
	private ArticleRepository articleRepository;
	
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	
	@Resource
	private ArticleService articleService;
	
	@Test
	public void test() {
		List<Article> article = articleService.getArticle();
	articleRepository.saveAll(article);
		
		
//		 PageInfo<Article> findByHighLight = (PageInfo<Article>) HLUtils.findByHighLight(elasticsearchTemplate, Article.class,1, 6, new
//				 String[] {"title"}, "id", "黑科技");
//		 List<Article> list = findByHighLight.getList();
//		 
//		for (Article article : list) {
//			System.out.println(article.getTitle());
//		}
	}
	
	
	
}
