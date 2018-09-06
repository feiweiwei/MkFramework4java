package com.monkey01.common.domain;

import io.swagger.annotations.ApiModel;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 * 
 * @author feiweiwei
 * @date 2016年10月27日 下午9:59:27
 */
@ApiModel(description= "返回响应数据")
public class MkResponse extends HashMap<String, Object> {
	private static final long serialVersionUID = 1L;

	public MkResponse() {
		put("returnCode", ResultCode.SUCCESS.getCode());
		put("returnMsg", ResultCode.SUCCESS.getMessage());
	}

	public MkResponse(ResultCode resultCode){
		put("returnCode", resultCode.getCode());
		put("returnMsg", resultCode.getMessage());
	}

	
	public static MkResponse error() {
		return error(ResultCode.UNKNOW_ERROR.getCode(), ResultCode.UNKNOW_ERROR.getMessage());
	}
	
	public static MkResponse error(String returnMsg) {
		return error(ResultCode.UNKNOW_ERROR.getCode(), returnMsg);
	}

	public static MkResponse error(ResultCode resultCode, String errorCode, String errorMsg){
		MkResponse r = new MkResponse();
		r.put("returnCode", resultCode.getCode());
		r.put("returnMsg", resultCode.getMessage());
		r.put("errorCode", errorCode);
		r.put("errorMsg", errorMsg);
		return r;
	}
	
	public static MkResponse error(String returnCode, String returnMsg) {
		MkResponse r = new MkResponse();
		r.put("returnCode", returnCode);
		r.put("returnMsg", returnMsg);
		return r;
	}

	public static MkResponse error(String returnCode, String returnMsg, String errorCode, String errorMsg) {
		MkResponse r = new MkResponse();
		r.put("returnCode", returnCode);
		r.put("returnMsg", returnMsg);
		r.put("errorCode", errorCode);
		r.put("errorMsg", errorMsg);
		return r;
	}

	public static MkResponse ok(String msg) {
		MkResponse r = new MkResponse();
		r.put("msg", msg);
		return r;
	}
	
	public static MkResponse ok(Map<String, Object> map) {
		MkResponse r = new MkResponse();
		r.putAll(map);
		return r;
	}
	
	public static MkResponse ok() {
		return new MkResponse();
	}

	@Override
	public MkResponse put(String key, Object value) {
		super.put(key, value);
		return this;
	}
}
