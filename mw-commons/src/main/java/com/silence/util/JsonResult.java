package com.silence.util;

/**
 * 统一封装JSON返回结果
 * 
 * @author silence
 *
 */
public class JsonResult {
	
	/**
	 * 操作结果
	 */
	private boolean success;
	
	/**
	 * 操作结果消息
	 */
	private String message;
	
	/**
	 * 操作结果数据
	 */
	private Object data;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	private JsonResult() {}
	
	private JsonResult(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}
	
	/**
	 * 构建表示操作成功信息的JsonResult对象
	 * @param message -操作成功的消息
	 * @param data -操作成功的数据信息
	 * @return -返回success为true的成功操作JsonResult对象
	 */
	public static JsonResult buildSuccessResult(String message,Object data) {
		return new JsonResult(true, message, data);
	}
	
	/**
	 * 构建表示操作成功信息的JsonResult对象
	 * @param message -操作成功的消息
	 * @return -返回success为true,data为null的成功操作的JsonResult对象
	 */
	public static JsonResult buildSuccessResult(String message) {
		return buildSuccessResult(message, null);
	}
	
	/**
	 * 构建表示操作成功信息的JsonResult对象
	 * @param data -操作成功的数据
	 * @return -返回success为true，message为null的成功操作的JsonResult对象
	 */
	public static JsonResult buildSuccessResult(Object data) {
		return buildSuccessResult(null, data);
	}
	
	/**
	 * 构建表示操作失败信息的JsonResult对象
	 * @param message -操作失败的信息
	 * @param data -操作失败时的数据
	 * @return -返回success为false的失败操作的JsonResult对象
	 */
	public static JsonResult buildFailureResult(String message, Object data) {
		return new JsonResult(false, message, data);
	}
	
	/**
	 * 构建表示操作失败信息的JsonResult对象
	 * @param message -操作失败的信息
	 * @return -返回success为false, data为null的失败操作的JsonResult对象
	 */
	public static JsonResult buildFailureResult(String message) {
		return buildFailureResult(message, null);
	}
	
	/**
	 * 构建表示操作失败信息的JsonResult对象
	 * @param data -操作失败的数据
	 * @return -返回success为false, message为null的失败操作的JsonResult对象
	 */
	public static JsonResult buildFailureResult(Object data) {
		return buildFailureResult(null, data);
	}
}
