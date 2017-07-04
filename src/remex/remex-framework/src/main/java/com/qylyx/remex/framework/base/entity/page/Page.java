package com.qylyx.remex.framework.base.entity.page;

import java.io.Serializable;
import java.util.List;

/**
 * 分页对象
 * 
 * @author Qiaoxin.Hong
 *
 * @param <T> 数据类型
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 当前页
	 */
    protected Long pageNum;
    
    /**
     * 每页的数量
     */
    protected Integer pageSize;
    
    /**
     * 总记录数
     */
    protected Long total;
    
    /**
     * 总页数
     */
    protected Long totalPage;
    
    /**
     * 数据
     */
    protected List<T> data;

	public Long getPageNum() {
		return pageNum;
	}
	
	public List<T> getRows() {
		return data;
	}

	public Page<T> setPageNum(Long pageNum) {
		this.pageNum = pageNum;
		return this;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public Page<T> setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
		return this;
	}

	public Long getTotal() {
		return total;
	}

	public Page<T> setTotal(Long total) {
		this.total = total;
		return this;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public Page<T> setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
		return this;
	}

	public List<T> getData() {
		return data;
	}

	public Page<T> setData(List<T> data) {
		this.data = data;
		return this;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + ", totalPage=" + totalPage
				+ ", data=" + data + "]";
	}
    
    
}
