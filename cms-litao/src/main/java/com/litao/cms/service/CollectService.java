package com.litao.cms.service;

import com.github.pagehelper.PageInfo;
import com.litao.cms.pojo.Collect;

public interface CollectService {

	PageInfo<Collect> getPageInfo(Integer user_id, int pageNum, int pageSize);

	boolean delByIds(String ids);

	boolean add(Collect collect);

	int getCollect(String string);

}
