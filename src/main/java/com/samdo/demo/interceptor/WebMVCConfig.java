package com.samdo.demo.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor());
//        .addPathPatterns("/secure-code")
//        .excludePathPatterns("/secure-code/public"); //by default applies to
	}

}
