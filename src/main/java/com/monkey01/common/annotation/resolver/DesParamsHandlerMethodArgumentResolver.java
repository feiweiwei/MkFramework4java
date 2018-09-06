package com.monkey01.common.annotation.resolver;

import cn.hutool.core.util.CharsetUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.monkey01.common.annotation.MkParams;
import com.monkey01.common.domain.MkRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;


/**
 * @author: feiweiwei
 * @description: @MkParams 解密注解处理类
 * @created Date: 16:12 18/9/5.
 * @modify by:
 */
@Component
public class DesParamsHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
	private Logger logger = LoggerFactory.getLogger(getClass());
	@Value("${mk.encrypt}")
	private boolean isEncrypt;
	@Value("${mk.key}")
	private String key;
	@Value("${mk.encryptAlgo}")
	private String encryptAlgo;

	@Override
	public boolean supportsParameter(MethodParameter methodParameter) {
		return isAssignAbleFrom(methodParameter) && methodParameter.hasParameterAnnotation(MkParams.class);
	}

	private boolean isAssignAbleFrom(MethodParameter parameter) {
		return parameter.getParameterType().isAssignableFrom(String.class) || parameter.getParameterType().isAssignableFrom(JSONObject.class)
				||parameter.getParameterType().isAssignableFrom(MkRequest.class);
	}

	@Override
	public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
			NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {

		HttpServletRequest httpRequest = nativeWebRequest.getNativeRequest(HttpServletRequest.class);
		String data = HttpUtil.getString(httpRequest.getInputStream(), null, true);
		if(isEncrypt == false){
			//未配置加密则直接返回
			return data;
		}

		logger.debug("上送未加密报文：" + data);
		SymmetricCrypto crypto;
		if(encryptAlgo.equalsIgnoreCase("des")) {
			crypto = new SymmetricCrypto(SymmetricAlgorithm.DES, key.getBytes());
		}else{
			crypto = new SymmetricCrypto(SymmetricAlgorithm.AES, key.getBytes());
		}
		data = crypto.decryptStr(data, CharsetUtil.CHARSET_UTF_8);
		logger.debug("上送解密报文：" + data);
		MkRequest mkRequest = JSONObject.parseObject(data, MkRequest.class);

		return mkRequest;
	}
}
