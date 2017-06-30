package com.qylyx.remex.iecup.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class IecupInterceptor {
	
	@Pointcut("execution(com.qylyx.remex.iecup.entity.Result com.qylyx.dts.service.impl.UserServiceImpl.*(..))")
	protected void iecupMethod() {}
	
	@Around("iecupMethod()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		System.out.println("========IecupInterceptor===========");
		return point.proceed();
	}
}
