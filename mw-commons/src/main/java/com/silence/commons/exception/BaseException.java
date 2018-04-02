package com.silence.commons.exception;

/**
 * 系统基础运行时异常
 * 	本系统中所有异常最终将转换为BaseException类型或其子类型，由统一异常处理器进行处理。
 * 
 * @author silence
 *
 */
public class BaseException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4406366622954201082L;

	public BaseException() {
		super();
	}

	public BaseException(String message, Throwable cause) {
		super(message, cause);
	}

	public BaseException(String message) {
		super(message);
	}

	public BaseException(Throwable cause) {
		super(cause);
	}
	
	

}
