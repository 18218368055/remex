package com.qylyx.remex.framework.entity.result;

/**
 * 接口操作结果
 * @author Qiaoxin.Hong
 *
 */
public class ResultBo<T> extends Result {
	private static final long serialVersionUID = 1L;

	/**
	 * 结果数据
	 */
	protected T data;
	
	/**
	 * 操作结果，默认成功，即code=100
	 */
	public ResultBo() {
		super();
	}
	
	/**
	 * 操作结果，默认成功，即code=100
	 * @param data 结果数据
	 */
	public ResultBo(T data) {
		this();
		this.data = data;
	}

	/**
	 * 操作结果
	 * @param code 结果代码
	 * @param msg 结果信息
	 */
	public ResultBo(String code, String msg) {
		super(code, msg);
	}

	/**
	 * 操作结果
	 * @param code 结果代码
	 * @param data 结果数据
	 * @param msg 结果信息
	 */
	public ResultBo(String code, T data, String msg) {
		super();
		this.code = code;
		this.data = data;
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ResultBo [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
}
