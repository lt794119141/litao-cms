package com.litao.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.litao.cms.dao.UserDao;
import com.litao.cms.pojo.User;
import com.litao.cms.service.UserService;

/**   
* @Title: UserServiceImpl.java 
* @Package com.wenjiaquan.cms.service.impl 
* @Description: TODO(用一句话描述该文件做什么) 
* @author A18ccms A18ccms_gmail_com   
* @date 2019年12月10日 下午6:22:40 
* @version V1.0   
*/
@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;
	
	public List<User> selectUser(){
		List<User> list=userdao.selectUser();
		return list;
	}
}
