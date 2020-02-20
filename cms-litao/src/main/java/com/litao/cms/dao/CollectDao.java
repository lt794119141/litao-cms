package com.litao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.litao.cms.pojo.Collect;

public interface CollectDao {

	// 根据用户id查询收藏的文章
	List<Collect> select(@Param("id")Integer id);

	boolean delByIds(@Param("ids")String ids);

	boolean add(@Param("collect")Collect collect);

	int getCollect(@Param("url")String url);
	
	

}
