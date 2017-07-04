package com.qylyx.remex.iecup.mop;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.qylyx.july.salog.extract.SalogExtractInfo;
import com.qylyx.remex.base.entity.ResultRequest;
import com.qylyx.remex.base.rconst.result.RemexResultConst;
import com.qylyx.remex.base.web.exception.RemexRequestException;

/**
 * spring mvc统一异常处理类，请求出现异常则进行日志打印及错误页面或数据格式的渲染，
 * 以RemexRequestException来作为标准的异常返回
 * 
 * @see com.qylyx.remex.base.web.exception.RemexRequestException
 * 
 * 
 * @author Qiaoxin.Hong
 *
 */
public class RemexExceptionResolver implements HandlerExceptionResolver {
	private final static Logger cerlogger = LoggerFactory.getLogger(RemexExceptionResolver.class);

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//当前请求类的日志记录器
		Logger logger = LoggerFactory.getLogger(handler.getClass());
		
		//请求页面，还是请求数据
		boolean isReqView = true;
		//日志前缀信息
		String logPrefix = "操作异常！";
		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			logPrefix = SalogExtractInfo.getLogPrefix(handlerMethod.getBeanType(), handlerMethod.getMethod());
			
			//暂时只判断方法上是否有ResponseBody注解来判断是请求页面还是数据
			isReqView = !handlerMethod.getMethod().isAnnotationPresent(ResponseBody.class);
		}
		
		String resultRequest = null;
		//RemexRequestException异常，则取其它信息进行日志打印及界面数据的返回
		if (ex.getClass().equals(RemexRequestException.class)) {
			RemexRequestException remexRequestException = (RemexRequestException) ex;
			if (StringUtils.isNotBlank(logPrefix))
				logPrefix += "，操作异常！ -";
			logger.error(logPrefix + remexRequestException.getLog(), remexRequestException);
			resultRequest = handleResultRequest(remexRequestException.getCode(), remexRequestException.getMsg());
		} else {  //其它异常
			logger.error("操作异常！", ex);
			resultRequest = handleResultRequest(RemexResultConst.CODE_FAIL, RemexResultConst.MSG_FAIL);
		}
		
		//请求页面，直接返回错误页面
		if (isReqView) {
			String errorView = handleErrorView(request, response, handler, ex);
			return new ModelAndView(errorView);
		} else {  //请求数据，以统一数据格式返回错误信息
			try {
				OutputStream out = response.getOutputStream();
				response.setContentType("application/json;charset=UTF-8");
				PrintWriter pw = new PrintWriter(out);
				pw.write(JSONObject.toJSONString(resultRequest));
				pw.flush();
				out.close();
			} catch (IOException e) {
				cerlogger.error("统一异常处理时异常！", e);
			}
			return null;
		}
	}
	
	/**
	 * 请求数据异常时，返回给前端的数据，默认使用ResultRequest的json格式，子类可重写来返回新的数据格式
	 * @see com.qylyx.remex.base.entity.ResultRequest
	 * @param code 异常代码
	 * @param showMsg 展示的异常信息
	 * @return
	 */
	protected String handleResultRequest(String code, String showMsg) {
		return JSONObject.toJSONString(new ResultRequest(RemexResultConst.CODE_FAIL, RemexResultConst.MSG_FAIL));
	}
	
	/**
	 * 错误视图界面
	 * @return
	 */
	protected String handleErrorView(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		return null;
	}
}
