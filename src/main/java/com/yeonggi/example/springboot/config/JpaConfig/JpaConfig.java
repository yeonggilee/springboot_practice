package com.yeonggi.example.springboot.config.JpaConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration //@WebMvcTest는 일반적인 @Configuration은 스캔하지 않음
@EnableJpaAuditing //JPA Auditing 활성화
public class JpaConfig {
}
