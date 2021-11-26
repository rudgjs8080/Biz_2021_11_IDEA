package com.rudgjs8080.book.web.dto;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        // given
        String name = "test code";
        int amount = 1000;

        // when
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        /**
         * assertThat -> assertj 라는 테스트 검증 라이브러리의 검증 메소드
         * 검증하고 싶은 대상을 메소드 인자로 받는다
         */
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }
}
