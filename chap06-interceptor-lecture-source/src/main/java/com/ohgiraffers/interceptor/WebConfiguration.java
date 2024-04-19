package com.ohgiraffers.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) { // IOC 컨테이너가 가지고있는 객체이다.

        registry.addInterceptor(new StopWatchInterceptor(new MenuService()))
                .addPathPatterns("/*")
                /*
                    static 하위의 정적 리소스는 인터셉터가 적용되지 않도록 한다.
                    path를 전부로 지정해줬기 때문에.
                 */
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/js/**")
                /*
                    /error로 포워딩되는 경로도 제외해주어야 한다.
                 */
                .excludePathPatterns("/error");

    }
}
