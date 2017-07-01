package com.qylyx.remex.iecup.config;

/**
 * iecup配置参数容器
 * 
 * @author Qiaoxin.Hong
 *
 */
public class IecupSetting {
	
	/**
	 * 是否打印日志
	 */
	protected boolean log = true;
	
	/**
	 * 是否支持从salog中提取日志信息的前缀
	 */
	protected boolean salog = true;

	public boolean isLog() {
		return log;
	}

	public void setLog(boolean log) {
		this.log = log;
	}

	public boolean isSalog() {
		return salog;
	}

	public void setSalog(boolean salog) {
		this.salog = salog;
	}
	
	

}
