package com.qylyx.remex.framework.entity.page;

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
    protected Long pageSize;
    
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
    protected List<T> datas;

	public Long getPageNum() {
		return pageNum;
	}

	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	public Long getPageSize() {
		return pageSize;
	}

	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "Page [pageNum=" + pageNum + ", pageSize=" + pageSize + ", total=" + total + ", totalPage=" + totalPage
				+ ", datas=" + datas + "]";
	}
    
    
}
