package com.qf.farmer.common.exception;

/**
 * 统一异常处理基类
 * @author qinfei
 *
 */
public class BusinessException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public BusinessException(String message){
		super(message);
	}

	public BusinessException(String message, Throwable cause){
		super(message, cause);
	}
	
	public BusinessException(Throwable cause){
		super(cause);
	}
}
