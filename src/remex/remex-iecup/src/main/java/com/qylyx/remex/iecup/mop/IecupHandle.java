package com.qylyx.remex.iecup.mop;

import java.lang.reflect.Method;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qylyx.july.salog.annotation.Salog;
import com.qylyx.remex.iecup.annotation.Iecup;
import com.qylyx.remex.iecup.config.IecupSetting;
import com.qylyx.remex.iecup.entity.ResultEup;
import com.qylyx.remex.iecup.exception.RemexIecupException;

/**
 * iecup接口异常集中统一处理核心处理器
 * 
 * @author Qiaoxin.Hong
 *
 */
public class IecupHandle {
	private final static Logger iecupLogger = LoggerFactory.getLogger(IecupHandle.class);
	
	/**
	 * iecup配置参数
	 */
	protected IecupSetting iecupSetting = new IecupSetting();
	
	/**
	 * 由自定义AOP转入此处理方法，进行接口异常集中统一处理
	 * @param point
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Object handle(ProceedingJoinPoint point) {
		ResultEup<?> result = null;
		try {
			return point.proceed();
		} catch (RemexIecupException e) {
			result = new ResultEup(e.getCode(), e.getMsg());
		} catch (Throwable e) {
			result = new ResultEup(RemexIecupException.ERROR_CODE, RemexIecupException.ERROR_MSG);
		}
		
		//进行异常结果集日志打印的相关处理
		if (iecupSetting.isLog())
			processException(point, result);
		
		return result;
	}
	
	/**
	 * 异常结果集日志打印的相关处理
	 * @param point
	 * @param result
	 */
	protected void processException(ProceedingJoinPoint point, ResultEup<?> result) {
		try {
			String logPrefix = "";
			Class<?> entityClass = point.getTarget().getClass();
			
			Method method = ((MethodSignature) point.getSignature()).getMethod();
			//如果是接口的实现类，则取实现类的method
			if (!method.getClass().equals(entityClass))
				method = entityClass.getMethod(method.getName(), method.getParameterTypes());
			
			Iecup iecup = null;
			if (method.isAnnotationPresent(Iecup.class)) {
				iecup = method.getAnnotation(Iecup.class);
				logPrefix = iecup.value() + " - ";
			}

			//允许打印日志
			if (iecup == null || iecup.log()) {
				//当开启了salog支持，从salog中提取日志信息的前缀
				if (iecupSetting.isSalog() && (iecup == null || iecup.salog())) {
					if (StringUtils.isBlank(logPrefix) && method.isAnnotationPresent(Salog.class)) {
						//是否有Salog注解
						if (entityClass.isAnnotationPresent(Salog.class)) {
							Salog salog = entityClass.getAnnotation(Salog.class);
							logPrefix += salog.value();
						}
						Salog salog = method.getAnnotation(Salog.class);
						if (StringUtils.isNotBlank(logPrefix))
							logPrefix += " - ";
						//解析封装方法上Salog注解的相关配置
						logPrefix += salog.value() + "，异常！ -";
					}
				}
				
				Logger logger = LoggerFactory.getLogger(point.getTarget().getClass());
				logger.error(logPrefix + result.getLog());
			}
		} catch (Exception e) {
			iecupLogger.error("iecup内部处理错误！", e);
		}
	}
	
	public void setIecupSetting(IecupSetting iecupSetting) {
		this.iecupSetting = iecupSetting;
	}
	
	public IecupSetting getIecupSetting() {
		return iecupSetting;
	}
}
