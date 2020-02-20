package com.litao.cms.listener;

import java.util.List;

import javax.annotation.Resource;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Component;

import com.litao.cms.pojo.Article;
import com.litao.cms.service.ArticleService;



@Component
public class KafkaConsumerListener implements MessageListener<String,String> {

	
	@Autowired
	private RedisTemplate<String, Article> template;
	
	@Resource
	private ArticleService articleServiceImpl;
	
	@Override
	public void onMessage(ConsumerRecord<String,String> data) {
		String value = data.value();
		System.out.println("收到消息"+value);
		
		ListOperations<String, Article> opsForList = template.opsForList();
		List<Article> range = opsForList.range(value, 0,-1);
		opsForList.remove(value, 0, -1);
		
		for (Article article : range) {
			articleServiceImpl.addArticle(article);
			System.out.println(article.getTitle()+"已导入完毕");
		}
		
	}

	

}
