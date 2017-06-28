package com.qylyx.remex.framework.entity.result;

import java.io.Serializable;

/**
 * web请求结果
 * @author Qiaoxin.Hong
 *
 */
public class RequestResult implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**结果代码 - 成功*/
	public final static String SUCCESS_CODE = "100";
	
	/**结果代码 - 失败*/
	public final static String FAIL_CODE = "101";
	
	/**错误提示信息 - 操作失败！*/
	public final static String FAIL_OP_MSG = "操作失败！";
	
	/**错误提示信息 - 查询失败！*/
	public final static String FAIL_QUERY_MSG = "查询失败！";

	/**
	 * 结果代码
	 * <pre>
	 * 100：成功
	 * 101：失败
	 * 其它自定义
	 * <pre>
	 */
	protected String code;
	
	/**
	 * 展示的结果信息
	 */
	protected String msg;
	
	/**
	 * 结果数据
	 */
	protected Object data;

	public RequestResult() {
		super();
	}

	public RequestResult(String code) {
		super();
		this.code = code;
	}

	public RequestResult(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public RequestResult(String code, String msg, Object data) {
		super();
		this.code = code;
		this.msg = msg;
		this.data = data;
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

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "RequestResult [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
