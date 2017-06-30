package com.qylyx.remex.iecup.entity;

public class Result<T> {
	/**
	 * 结果代码-成功
	 */
	public final static String SUCCESS_CODE = "100";
	
	/**
	 * 结果代码
	 * <pre>
	 * 100：成功
	 * 101：失败
	 * 102：入参异常
	 * 103：接口处理失败
	 * <pre>
	 */
	protected String code;
	
	/**
	 * 结果信息
	 */
	protected String msg;
	
	/**
	 * 结果数据
	 */
	protected T data;
	
	/**
	 * 构建基础操作的结果，默认成功，即code=100
	 */
	public Result() {
		super();
		setCode(SUCCESS_CODE);
	}
	
	/**
	 * 操作结果，默认成功，即code=100
	 * @param data 结果数据
	 */
	public Result(T data) {
		super();
		this.data = data;
	}
	
	/**
	 * 构建基础操作的结果
	 * @param code 结果代码
	 * @param msg 结果信息
	 */
	public Result(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}
	
	/**
	 * 操作结果
	 * @param code 结果代码
	 * @param data 结果数据
	 * @param msg 结果信息
	 */
	public Result(String code, T data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
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

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
