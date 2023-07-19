package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class MultipartConfig {

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setMaxUploadSizePerFile(10 * 1024 * 1024); // 파일 당 최대 크기 설정 (10MB)
        resolver.setMaxUploadSize(100 * 1024 * 1024); // 요청당 최대 크기 설정 (100MB)
        return resolver;
    }
}
