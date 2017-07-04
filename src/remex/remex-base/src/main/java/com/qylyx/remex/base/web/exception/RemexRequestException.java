package com.qylyx.remex.base.web.exception;

import com.qylyx.remex.base.exception.RemexException;
import com.qylyx.remex.base.rconst.result.RemexResultConst;

/**
 * 用于web请求控制器处理所抛出的一个异常类，可考虑用于进行web请求异常的集中处理，主要定位于界面展示方向
 * 
 * @author Qiaoxin.Hong
 *
 */
public class RemexRequestException extends RemexException {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 异常结果代码
	 */
	protected String code = RemexResultConst.CODE_FAIL;
	
	/**
	 * 用于页面展示的异常提示信息
	 */
	protected String msg = RemexResultConst.MSG_FAIL;
	
	/**
	 * 异常提示信息，主要是服务器处理的信息，并不适合展示到页面，可用于打印日志
	 */
	protected String serverMsg = RemexResultConst.MSG_FAIL;
	
	
	public RemexRequestException() {
		super();
	}
	
	public RemexRequestException(String code, String msg) {
		super(msg);
		setCode(code);
		setMsg(msg);
	}
	
	public RemexRequestException(String code, String msg, String serverMsg) {
		super(msg);
		setCode(code);
		setMsg(msg);
		setServerMsg(serverMsg);
	}
	
	public RemexRequestException(String msg) {
		super(msg);
		setMsg(msg);
	}
	
	public RemexRequestException(String msg, Throwable cause) {
		super(msg, cause);
		setMsg(msg);
	}
	
	public RemexRequestException(String msg, String serverMsg, Throwable cause) {
		super(msg, cause);
		setMsg(msg);
		setServerMsg(serverMsg);
	}
	
	public RemexRequestException(Throwable cause) {
		super(cause);
	}

	/**
	 * 可打印的拼接好的日志信息
	 * @return
	 */
	public String getLog() {
		return " [code=" + code + ", msg=" + msg
				+ ", serverMsg=" + serverMsg + "]";
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getServerMsg() {
		return serverMsg;
	}

	public void setServerMsg(String serverMsg) {
		this.serverMsg = serverMsg;
	}

	@Override
	public String toString() {
		return "RemexRequestException [code=" + code + ", msg=" + msg
				+ ", serverMsg=" + serverMsg + "]";
	}
}
