package com.zzz.config;

import com.google.common.collect.ImmutableList;
import com.zzz.interceptor.AuthHandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

/**
 * @author hushengjun
 * @date 2018/3/6
 */
@Component
public class WebMvcConfig implements WebMvcConfigurer {

    private static final List<String> EXCLUDE_PATH_PATTERNS = ImmutableList.of("/static/**", "/index.html", "/error", "/auth/login", "/auth/logout");

    @Autowired
    private AuthHandlerInterceptor handlerInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(handlerInterceptor)
                .excludePathPatterns(EXCLUDE_PATH_PATTERNS)
                .addPathPatterns("/**");
    }

}
