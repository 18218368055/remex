package com.qylyx.remex.iecup.exception;


/**
 * 接口异常集中统一处理的异常载体
 * 
 * @author Qiaoxin.Hong
 *
 */
public class RemexIecupException extends RuntimeException {
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
	
	
	public RemexIecupException() {
		super();
		setCode(ERROR_CODE);
		setMsg(ERROR_MSG);
	}
	
	public RemexIecupException(String code, String message) {
		super(message);
		setCode(code);
		setMsg(message);
	}
	
	public RemexIecupException(String message) {
		super(message);
		setCode(ERROR_CODE);
		setMsg(message);
	}
	
	public RemexIecupException(String message, Throwable cause) {
		super(message, cause);
		setCode(ERROR_CODE);
		setMsg(message);
	}
	
	public RemexIecupException(Throwable cause) {
		super(cause);
		setCode(ERROR_CODE);
		setMsg(ERROR_MSG);
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
