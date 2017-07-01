package com.qylyx.remex.iecup.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import com.qylyx.remex.iecup.mop.IecupHandle;

/**
 * iecup接口异常集中统一处理的父拦截器，可以继承来快速配置拦截器，默认拦截返回Result的方法，以aop环绕通知来进行异常的统一处理
 * @see com.qylyx.remex.iecup.entity.Result
 * 
 * @author Qiaoxin.Hong
 *
 */
@Aspect
public class IecupInterceptor {
	
	/**
	 * 切点，默认拦截返回Result的方法
	 * @see com.qylyx.remex.iecup.entity.Result
	 */
	@Pointcut("execution(com.qylyx.remex.iecup.entity.Result com.qylyx.dts.service.impl.UserServiceImpl.*(..))")
	protected void iecupMethod() {}
	
	/**
	 * iecup接口异常集中统一处理的核心处理器，子类可以对此处理器进行设置
	 */
	protected IecupHandle iecupHandle = new IecupHandle();
	
	/**
	 * aop环绕通知
	 * @param point
	 * @return
	 */
	@Around("iecupMethod()")
	public Object around(ProceedingJoinPoint point) {
		return iecupHandle.handle(point);
	}
}
