package com.shop.gabia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//환경설정
@Configuration
public class WebConfig {
    //객체 자동화.
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173") // 또는 5173
                        .allowedMethods("*") //모든 http 메서드 허용 (get, put, delete, post)
                        .allowedHeaders("*") //모든 헤더 ("Content- Type" , "Authorization")
                        .allowCredentials(true); // 쿠키, 인증헤더 자격증명 허용
            }
        };
    }
}

/*
 * cors (cross - origin Resource Sharing) 웹 브라우저 보안 정책.
 * 브라우저 보안: 다른 도메인 (요청하지않은  url 포트 요청 공격 차단)
 * 프론트엔드 백엔드 분리. REACT :5173 => Spring boot: 8080
 * API호출 : 프론트에서 백엔드로 요청하는것만 허용
 */