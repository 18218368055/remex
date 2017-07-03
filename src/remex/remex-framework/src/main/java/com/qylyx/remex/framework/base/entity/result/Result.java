package com.qylyx.remex.framework.base.entity.result;

import com.qylyx.remex.base.rconst.result.RemexResultConst;
import com.qylyx.remex.base.web.exception.RemexRequestException;

public class Result<T> {
	
	/**
	 * 结果代码
	 * <pre>
	 * 100：成功
	 * 101：操作异常
	 * 102：入参异常
	 * 103：接口处理失败
	 * 104：控制层处理失败
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
		setCode(RemexResultConst.CODE_SUCCESS);
	}
	
	/**
	 * 操作结果，默认成功，即code=100
	 * @param data 结果数据
	 */
	public Result(T data) {
		super();
		setCode(RemexResultConst.CODE_SUCCESS);
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
	
	/**
	 * 是否操作成功
	 * @return
	 */
	public boolean isSuccess() {
		return RemexResultConst.CODE_SUCCESS.equals(this.code);
	}
	
	/**
	 * 是否操作失败
	 * @return
	 */
	public boolean isFailed() {
		return !isSuccess();
	}
	
	/**
	 * 在请求接口的地方获取结果数据时使用，在操作失败（即code != 100）时，会抛出RemexRequestException异常，可用于类似请求的集中处理等
	 * @see com.qylyx.remex.base.web.exception.RemexRequestException
	 * @return
	 */
	public T getDataWeb() {
		if (isFailed())
			throw new RemexRequestException(code, RemexResultConst.MSG_FAIL, msg);
		return data;
	}
	
	/**
	 * 可打印的拼接好的日志信息
	 * @return
	 */
	public String getLog() {
		return " [code=" + code + ", msg=" + msg + "]";
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

	@Override
	public String toString() {
		return "Result [code=" + code + ", msg=" + msg + ", data=" + data + "]";
	}
	
	
}
