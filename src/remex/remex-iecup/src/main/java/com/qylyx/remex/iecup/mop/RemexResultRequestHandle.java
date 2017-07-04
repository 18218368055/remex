package com.qylyx.remex.iecup.mop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.qylyx.remex.base.entity.ResultRequest;

/**
 * 用于处理spring mvc请求结果，将其转换为统一输出格式ResultRequest，
 * 请求方法返回类型必须是Object的，或String的，或直接就是ResultRequest类型的，
 * 针对非页面的数据的请求方式，即类上有RestController注解或方法上有ResponseBody注解的
 * 
 * @see com.qylyx.remex.base.entity.ResultRequest
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.ResponseBody
 * 
 * @author Qiaoxin.Hong
 *
 */
public class RemexResultRequestHandle {
	
	public Object handle(ProceedingJoinPoint point) throws Throwable {
		//是否是数据请求方式
		boolean isData = false;
		
		//controller是否有RestController
		Class<?> entityClass = point.getTarget().getClass();
		isData = entityClass.isAnnotationPresent(RestController.class);
		
		Method method = ((MethodSignature) point.getSignature()).getMethod();
		//方法上是否有ResponseBody注解
		if (!isData)
			isData = method.isAnnotationPresent(ResponseBody.class);
		
		//方法执行
		Object obj = point.proceed();
		
		//转换数据格式
		if (isData) {
			Class<?> returnClass = method.getReturnType();
			if (obj == null)
				return new ResultRequest();
			if (returnClass.equals(String.class))
				return parseJson(obj);
			if (obj instanceof ResultRequest)
				return obj;
			if (returnClass.equals(Object.class))
				return new ResultRequest(obj);
			
			//返回结果类型不对时，是抛出异常还是直接返回结果
			if (isExceptionByType())
				throw new ClassCastException("返回结果不是Object、String、ResultRequest！");
			else
				return obj;
		} else {  //页面请求，返回原始路径
			return obj;
		}
	}
	
	/**
	 * 在返回值是String类型时，将结果转换为json
	 * @param obj
	 * @return
	 */
	protected String parseJson(Object obj) {
		return JSONObject.toJSONString(obj);
	}
	
	/**
	 * 返回类型不符合规范时，是否抛出异常
	 * @return
	 */
	protected boolean isExceptionByType() {
		return true;
	}
}
