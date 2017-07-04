package com.qylyx.remex.framework.base.entity.page;

/**
 * 分页查询条件参数
 * 
 * @author Qiaoxin.Hong
 *
 */
public class PageCo {
	/**
	 * 当前页
	 */
    protected Long pageNum = 1L;
    
    /**
     * 每页的数量
     */
    protected Integer pageSize = 10;

	public PageCo() {
		super();
	}

	public PageCo(Long pageNum) {
		super();
		this.pageNum = pageNum;
	}

	public PageCo(Long pageNum, Integer pageSize) {
		super();
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Long getPageNum() {
		return pageNum;
	}

	public void setPageNum(Long pageNum) {
		this.pageNum = pageNum;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PageCo [pageNum=" + pageNum + ", pageSize=" + pageSize + "]";
	}
    
    
}
