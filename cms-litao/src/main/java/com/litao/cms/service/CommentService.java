package com.litao.cms.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bawei.utils.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litao.cms.dao.CommentDao;
import com.litao.cms.pojo.Comment;
import com.litao.cms.pojo.User;
@Service
public class CommentService {
	@Autowired
	private CommentDao commentDao;
	/**
	 * @Title: add   
	 * @Description: 添加评论   
	 * @param: @param comment
	 * @param: @return      
	 * @return: boolean      
	 * @throws
	 */
	public boolean add(Comment comment) {
		String createdStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		comment.setCreated(createdStr);
		return commentDao.insert(comment)>0;
	}
	/**
	 * @Title: getPageInfo   
	 * @Description: 根据文章Id,查询评论   
	 * @param: @param articleId
	 * @param: @param pageNum
	 * @param: @return      
	 * @return: PageInfo<Comment>      
	 * @throws
	 */
	public PageInfo<Comment> getPageInfo(Integer articleId,int pageNum){
		PageHelper.startPage(pageNum, 2);
		Comment comment = new Comment();
		comment.setArticleid(articleId);
		List<Comment> commentList = commentDao.select(comment);
		return new PageInfo<>(commentList);
	}
	public PageInfo<Comment> getPageInfoById(User user, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		Comment comment = new Comment();
		comment.setUserid(user.getId());
		List<Comment> commentList = commentDao.selectByUser(comment);
		return new PageInfo<>(commentList);
	}
	
	
}