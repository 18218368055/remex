package com.qylyx.remex.iecup.annotation;

/**
 * 接口异常集中统一处理配置
 * 
 * @author Qiaoxin.Hong
 *
 */
public @interface Iecup {
	
	/**
	 * 是否打印日志
	 * @return
	 */
	boolean log() default true;
	
	/**
	 * 打印日志的前缀，如有使用salog时，则可考虑不设，默认会提取salog中的日志信息的前缀，如设置则会屏蔽掉salog
	 * @return
	 */
	String value() default "";
	
	/**
	 * 是否支持从salog中提取日志信息的前缀
	 * @return
	 */
	boolean salog() default true;
}
