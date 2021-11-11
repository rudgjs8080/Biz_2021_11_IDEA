package com.rudgjs.sec.exec;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Bcrypt_01 {
    public static void main(String[] args) {
        /**
         * 암호화, 복호화
         *
         * 보안과 관련 용어중 "인가"
         * username, password 를 입력받아
         * 정상적인 사용자 username password 인지 검사하고
         * 접속을 허가 하는 절차
         *
         * 이때 username 은 보통 문자열로 구성하지만
         * password 는 가급적 노출되지 않도록 "암호화(encrypt)"를 한다
         *
         * 암호화된 password 를 DB에 저장하고
         * 저장된 암호화 password 를 다시 "복호화" 하여 로그인 정보와 비교한다
         *
         * 단방향 암호화를 이용한 보안
         * PasswordEncoder(BcryptPasswordEncoder 로 구현)
         * 회원가입을 할 때 비번을 암호화 하여 저장을 하고
         *
         * 로그인을 할 때
         * DB 에서 회원정보를 SELECT 한 후
         * login 을 통해 전달된 Password 와 비교를 하는데
         *
         * DB 에 저장된 password 를 복호화 하지 않고
         * login 을 통해 전달된 Password 를 다시 암호화 하여
         * 두 값을 비교한다
         */
        PasswordEncoder pass = new BCryptPasswordEncoder(4);
        String password = "12345";
        String encpassword = "$2a$04$dkxy4qbeq7pd4mt3Lt8dNuHlrK9F1Z8shzqjf/0g5BXyJcDriAXmi";

        String bcPassword = pass.encode(password);
        System.out.println(bcPassword);

        // matches(rowPassword, encPassword)
        boolean loginOk = pass.matches(password, encpassword);

        if(loginOk){
            System.out.println("맞았습니다");
        } else {
            System.out.println("틀림");
        }
    }
}
