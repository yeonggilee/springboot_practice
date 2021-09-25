package com.yeonggi.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JPA Auditing 활성화 - 최소 하나의 @Entity 클래스 필요
//@EnableJpaAuditing 을 @WebMvcTest에서도 스캔 -> config 패키지에 분리 생성하기
@SpringBootApplication //스프링 부트의 자동설정, 스프링 Bean 읽기와 생성을 모두 자동으로 설정
//@SpringBootApplication 이 있는 위치부터 설정을 읽어가기때문에 이 클래스는 항상 프로젝트 최상단에 위치
public class Application { //메인클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);//내장 WAS 실행
        //항상 서버에 톰캣을 설치할 필요가 없게되고, 스프링부트로 만들어진 Jar 파일로 실행
    }
}
