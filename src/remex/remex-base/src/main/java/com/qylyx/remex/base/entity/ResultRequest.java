package com.qylyx.remex.base.entity;

import java.io.Serializable;

import com.qylyx.remex.base.rconst.result.RemexResultConst;

/**
 * web请求结果
 * @author Qiaoxin.Hong
 *
 */
public class ResultRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 结果代码
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

	public ResultRequest() {
		super();
		setCode(RemexResultConst.CODE_SUCCESS);
	}

	public ResultRequest(Object data) {
		super();
		setData(data);
		setCode(RemexResultConst.CODE_SUCCESS);
	}

	public ResultRequest(String code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public ResultRequest(String code, String msg, Object data) {
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
