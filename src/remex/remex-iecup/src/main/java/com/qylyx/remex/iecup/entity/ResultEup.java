package com.qylyx.remex.iecup.entity;

import com.qylyx.remex.framework.base.entity.result.Result;
import com.qylyx.remex.iecup.exception.RemexIecupException;

public class ResultEup<T> extends Result<T> {

	public ResultEup() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultEup(String code, String msg) {
		super(code, msg);
		// TODO Auto-generated constructor stub
	}

	public ResultEup(String code, T data, String msg) {
		super(code, data, msg);
		// TODO Auto-generated constructor stub
	}

	public ResultEup(T data) {
		super(data);
		// TODO Auto-generated constructor stub
	}
	
	public T getDataWeb() {
		if (isFailed())
			throw new RemexIecupException(code, msg);
		return data;
	}
	
}
