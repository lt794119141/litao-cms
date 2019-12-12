package com.litao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.litao.cms.pojo.User;

/**   
* @Title: UserDao.java 
* @Package com.wenjiaquan.cms.dao 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2019年12月10日 下午6:21:58 
* @version V1.0   
*/
public interface UserDao {
	@Select("select * from cms_user")
	List<User> selectUser();

}
