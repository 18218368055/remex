package com.qylyx.remex.framework.base.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qylyx.remex.base.service.exception.RemexServiceException;
import com.qylyx.remex.framework.base.entity.page.Page;
import com.qylyx.remex.framework.base.entity.page.PageCo;

/**
 * remex基础service
 * 
 * @author Qiaoxin.Hong
 *
 */
public class BaseService {
	/**
	 * 日志记录器
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	/**
	 * 验证查询条件，有问题会抛出RemexServiceException异常
	 * @see com.qylyx.remex.base.service.exception.RemexServiceException
	 * 
	 * @param co 分页查询条件参数
	 */
	protected void validatePageCo(PageCo co) {
		if (co == null)
			throw new RemexServiceException("201", "分页参数不能为空！");
		if (co.getPageNum() == null || co.getPageNum() < 1L)
			throw new RemexServiceException("201", "分页参数当前页不能为空并且要大于0！");
		if (co.getPageSize() == null || co.getPageNum() < 1L)
			throw new RemexServiceException("201", "分页参数每页数量不能为空并且要大于0！");
	}
	
	/**
	 * 创建分页对象
	 * @param co 分页查询条件参数
	 * @return
	 */
	protected <T> Page<T> createPage(PageCo co) {
		Page<T> page = new Page<T>();
		page.setPageNum(co.getPageNum());
		page.setPageSize(co.getPageSize());
		return page;
	}
}
