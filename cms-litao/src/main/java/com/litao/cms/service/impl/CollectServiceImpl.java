package com.litao.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.litao.cms.dao.CollectDao;
import com.litao.cms.pojo.Article;
import com.litao.cms.pojo.Collect;
import com.litao.cms.service.CollectService;

@Service
public class CollectServiceImpl implements CollectService {

	@Autowired
	private CollectDao collectDao;
	
	@Override
	public PageInfo<Collect> getPageInfo(Integer user_id, int pageNum, int pageSize) {
		// TODO Auto-generated method stub
		System.out.println("++++++++++++++++++++"+pageNum+"  "+pageSize);
		PageHelper.startPage(pageNum, pageSize);
		List<Collect> list = collectDao.select(user_id);
		System.out.println(list);
		return new PageInfo<Collect>(list);
	}

	@Override
	public boolean delByIds(String ids) {
		// TODO Auto-generated method stub
		return collectDao.delByIds(ids);
	}

	@Override
	public boolean add(Collect collect) {
		// TODO Auto-generated method stub
		return collectDao.add(collect);
	}

	@Override
	public int getCollect(String string) {
		// TODO Auto-generated method stub
		return collectDao.getCollect("http://127.0.0.1/article?id="+string);
	}

	
}
