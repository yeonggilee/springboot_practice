package com.yeonggi.example.springboot.web.dto;

import org.junit.Test;

//import static org.junit.Assert.assertThat; //Junit
import static org.assertj.core.api.Assertions.assertThat;
//assertj - 추가적으로 라이브러리가 필요하지 않고, 자동완성이 좀 더 확실하게 지원됩니다.

public class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given
        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name);//1.2.
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
/*
1.assertThat
- assertj라는 테스트 검증 라이브러리의 검증 메소드입니다.
- 검증하고 싶은 대상을 메소드 인자로 받습니다.
- 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용할 수 있습니다.
2.isEqualTo
- assertj의 동등비교 메소드 입니다.
- assertThat에 있는 값과 isEqualTo의 값을 비교해서 같을 때만 성공입니다.*/
