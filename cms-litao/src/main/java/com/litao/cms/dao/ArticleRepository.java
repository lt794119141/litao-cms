package com.litao.cms.dao;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.litao.cms.pojo.Article;

public interface ArticleRepository extends ElasticsearchRepository<Article,Integer>{
	List<Article> findByTitle(String title);
	
	List<Article> findByTitleOrContent(String title,String Content);
}
