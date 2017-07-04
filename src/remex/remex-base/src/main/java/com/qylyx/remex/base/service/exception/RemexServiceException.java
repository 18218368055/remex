package com.qylyx.remex.base.service.exception;


/**
 * 接口异常集中统一处理的异常载体
 * 
 * @author Qiaoxin.Hong
 *
 */
public class RemexServiceException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常结果代码 - 操作异常
	 */
	public final static String ERROR_CODE = "101";
	
	/**
	 * 异常提示提示 - 操作异常！
	 */
	public final static String ERROR_MSG = "操作异常！";
	
	/**
	 * 异常结果代码
	 */
	protected String code;
	
	/**
	 * 异常提示信息
	 */
	protected String msg;
	
	
	public RemexServiceException() {
		super();
		setCode(ERROR_CODE);
		setMsg(ERROR_MSG);
	}
	
	public RemexServiceException(String code, String message) {
		super(message);
		setCode(code);
		setMsg(message);
	}
	
	public RemexServiceException(String message) {
		super(message);
		setCode(ERROR_CODE);
		setMsg(message);
	}
	
	public RemexServiceException(String message, Throwable cause) {
		super(message, cause);
		setCode(ERROR_CODE);
		setMsg(message);
	}
	
	public RemexServiceException(Throwable cause) {
		super(cause);
		setCode(ERROR_CODE);
		setMsg(ERROR_MSG);
	}

	/**
	 * 可打印的拼接好的日志信息
	 * @return
	 */
	public String getLog() {
		return " [code=" + code + ", msg=" + msg + "]";
	}
	
	
	

	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return msg;
	}
	
}
