//package com.qylyx.remex.framework.base.entity.result;
//
//import java.io.Serializable;
//
///**
// * 接口基础操作的结果
// * @author Qiaoxin.Hong
// *
// */
//public class Result1 implements Serializable {
//	private static final long serialVersionUID = 1L;
//
//	/**
//	 * 结果代码-成功
//	 */
//	public final static String SUCCESS_CODE = "100";
//	
//	/**
//	 * 结果代码
//	 * <pre>
//	 * 100：成功
//	 * 101：失败
//	 * 102：入参异常
//	 * 103：接口处理失败
//	 * <pre>
//	 */
//	protected String code;
//	
//	/**
//	 * 结果信息
//	 */
//	protected String msg;
//	
//	/**
//	 * 构建基础操作的结果，默认成功，即code=100
//	 */
//	public Result1() {
//		super();
//		setCode(SUCCESS_CODE);
//	}
//	
//	/**
//	 * 构建基础操作的结果
//	 * @param code 结果代码
//	 */
//	public Result1(String code) {
//		super();
//		this.code = code;
//	}
//
//	/**
//	 * 构建基础操作的结果
//	 * @param code 结果代码
//	 * @param msg 结果信息
//	 */
//	public Result1(String code, String msg) {
//		super();
//		this.code = code;
//		this.msg = msg;
//	}
//	
//	/**
//	 * 是否操作成功
//	 * @return
//	 */
//	public boolean isSuccess() {
//		return SUCCESS_CODE.equals(this.code);
//	}
//	
//	/**
//	 * 是否操作失败
//	 * @return
//	 */
//	public boolean isFailed() {
//		return !isSuccess();
//	}
//	
//	/**
//	 * 可打印的拼接好的日志信息
//	 * @return
//	 */
//	public String getLog() {
//		return " [code=" + code + ", msg=" + msg + "]";
//	}
//
//	public String getCode() {
//		return code;
//	}
//
//	public void setCode(String code) {
//		this.code = code;
//	}
//
//	public String getMsg() {
//		return msg;
//	}
//
//	public void setMsg(String msg) {
//		this.msg = msg;
//	}
//
//	@Override
//	public String toString() {
//		return "BaseResult [code=" + code + ", msg=" + msg + "]";
//	}
//	
//	
//}
