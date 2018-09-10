package com.monkey01.common.config;

import com.monkey01.common.annotation.interceptor.AuthorizationInterceptor;
import com.monkey01.common.annotation.resolver.DesParamsHandlerMethodArgumentResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * MVC配置
 *
 * @author feiweiwei
 * @email
 * @date 2017-04-20 22:30
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private DesParamsHandlerMethodArgumentResolver desParamsHandlerMethodArgumentResolver;
    @Autowired
	private AuthorizationInterceptor authorizationInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(authorizationInterceptor).addPathPatterns("/**");
	}
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(desParamsHandlerMethodArgumentResolver);
    }
}