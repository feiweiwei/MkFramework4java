package com.monkey01.common.exception;

/**
 * 自定义异常
 * 
 * @author feiweiwei
 * @date 2016年10月27日 下午10:11:27
 */
public class MkException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
    private String returnMsg;
	/**
	 * returnCode 表示HOP内部错误码
	 */
    private String returnCode = "999999";
    private String errorMsg;

	/**
	 * errorCode 表示后台系统返回错误码
	 */
    private String errorCode = "999999";
    
    public MkException(String returnMsg) {
		super(returnMsg);
		this.returnMsg = returnMsg;
	}
	
	public MkException(String returnMsg, Throwable e) {
		super(returnMsg, e);
		this.returnMsg = returnMsg;
	}
	
	public MkException(String returnMsg, String returnCode) {
		super(returnMsg);
		this.returnMsg = returnMsg;
		this.returnCode = returnCode;
	}
	
	public MkException(String returnMsg, String returnCode, Throwable e) {
		super(returnMsg, e);
		this.returnMsg = returnMsg;
		this.returnCode = returnCode;
	}

	public MkException(String returnMsg, String returnCode, String errorMsg, String errorCode) {
		super(returnMsg);
		this.returnMsg = returnMsg;
		this.returnCode = returnCode;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	public MkException(String returnMsg, String returnCode, String errorMsg, String errorCode, Throwable e) {
		super(returnMsg, e);
		this.returnMsg = returnMsg;
		this.returnCode = returnCode;
		this.errorMsg = errorMsg;
		this.errorCode = errorCode;
	}

	public MkException(ResultCode resultCode, Throwable e) {
		super(resultCode.getMessage(), e);

		this.errorMsg = resultCode.getMessage();
		this.errorCode = resultCode.getCode();
	}

	public MkException(ResultCode resultCode) {
		this.errorMsg = resultCode.getMessage();
		this.errorCode = resultCode.getCode();
	}

	public String getReturnMsg() {
		return returnMsg;
	}

	public void setReturnMsg(String returnMsg) {
		this.returnMsg = returnMsg;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
}
