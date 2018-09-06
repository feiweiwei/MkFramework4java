package com.monkey01.common.exception;


import com.monkey01.common.domain.MkResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;

/**
 * 异常处理器
 * 
 * @author feiweiwei
 * @date 2016年10月27日 下午10:16:19
 */
@RestControllerAdvice
public class MkExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(getClass());

	private final static String NO_URL_FOUND = "404";

	/**
	 * 处理自定义异常
	 */
	@ExceptionHandler(MkException.class)
	public MkResponse handleHOPException(MkException e){
		MkResponse r = new MkResponse();
		r.put("returnCode", e.getReturnCode());
		r.put("returnMsg", e.getReturnMsg());
		r.put("errorCode", e.getErrorCode());
		r.put("errorMsg", e.getErrorMsg());
		logger.error(new Date() + ": " + e.getMessage(), e);
		return r;
	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public MkResponse handlerNoFoundException(Exception e) {
		logger.error(new Date() + ": " + e.getMessage(), e);
		return MkResponse.error(NO_URL_FOUND, "路径不存在，请检查路径是否正确");
	}


	@ExceptionHandler(Exception.class)
	public MkResponse handleException(Exception e){
		logger.error(new Date() + ": " + e.getMessage(), e);
		return MkResponse.error(e.getMessage());
	}
}
