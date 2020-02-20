package com.litao.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageInfo;
import com.litao.cms.pojo.Article;
import com.litao.cms.pojo.Category;
import com.litao.cms.pojo.Channel;
import com.litao.cms.service.RedisArticleService; 

@Service
public class RedisArticleServiceImpl implements RedisArticleService{
	
	@Autowired
	private RedisTemplate<String, Article> template;
	
	@Autowired
	private KafkaTemplate<String, String> template2;
	
	public boolean save(Article article) {
		ListOperations<String, Article> opsForList = template.opsForList();
		opsForList.leftPush("article_new",article);
		
		template2.send("1709d", "article_new");
		return false;
	}

	
}
