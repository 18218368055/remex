package com.qylyx.remex.framework.base.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qylyx.july.utils.tolerant.TolerantUtils;
import com.qylyx.remex.base.entity.Result;
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
	 * 以list创建一个结果集对象
	 * @param list
	 * @return
	 */
	protected <T> Result<List<T>> createResult(List<T> list) {
		return new Result<List<T>>(TolerantUtils.defaultList(list));
	}
	
	/**
	 * 验证分页查询条件，有问题会抛出RemexServiceException异常
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
	
	/**
	 * 启动分页功能
	 * @param co
	 */
	protected void startPage(PageCo co) {
		//验证分页条件参数
		validatePageCo(co);
		//启动分页
		PageHelper.startPage(co.getPageNum().intValue(), co.getPageSize());
	}
	
	/**
	 * 封装分页数据，从pagehelper插件中的PageInfo提取数据，封装成remex定义的分页对象
	 * @see com.github.pagehelper.PageInfo<T>
	 * 
	 * @param list 列表数据
	 * @return 
	 */
	protected <T> Page<T> packPageBasic(List<T> list) {
		//分页插件pagehelper封装的分页对象
		PageInfo<T> pageInfo = new PageInfo<>(list);
		
		Page<T> page = new Page<T>();
		page.setPageNum(Long.valueOf(pageInfo.getPageNum()));
		page.setPageSize(pageInfo.getPageSize());
		page.setTotal(pageInfo.getTotal());
		page.setTotalPage(Long.valueOf(pageInfo.getPages()));
		page.setData(TolerantUtils.defaultList(pageInfo.getList()));
		return page;
	}
	
	/**
	 * 封装分页数据，从pagehelper插件中的PageInfo提取数据，封装成remex定义的分页对象
	 * @see com.github.pagehelper.PageInfo<T>
	 * 
	 * @param list 列表数据
	 * @return 
	 */
	protected <T> Result<Page<T>> packPage(List<T> list) {
		return new Result<Page<T>>(packPageBasic(list));
	}
}
