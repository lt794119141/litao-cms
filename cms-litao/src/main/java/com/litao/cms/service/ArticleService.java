package com.litao.cms.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.litao.cms.pojo.Article;
import com.litao.cms.pojo.Channel;
import com.litao.cms.pojo.User;

public interface ArticleService {
	/**
	 * @Title: getPageInfo   
	 * @Description: 分页列表   
	 * @param: @param user
	 * @param: @param pageNum
	 * @param: @param pageSize
	 * @param: @return      
	 * @return: PageInfo<Article>      
	 * @throws
	 */
	PageInfo<Article> getPageInfo(Article article, int pageNum,int pageSize); 
	/**
	 * @Title: updateStatus   
	 * @Description: 修改文章状态   
	 * @param: @param id
	 * @param: @param status
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean updateStatus(Integer id,int status);
	/**
	 * @Title: addHot   
	 * @Description: 加热，每次给hot值加1   
	 * @param: @param id
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean addHot(Integer id);
	/**
	 * @Title: getChannelList   
	 * @Description: 查询频道列表   
	 * @param: @return      
	 * @return: List<Channel>      
	 * @throws
	 */
	public List<Channel> getChannelList();
}
