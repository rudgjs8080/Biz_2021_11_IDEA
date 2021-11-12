package com.rudgjs.sec.service;

import com.rudgjs.sec.models.UserDetailsVO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * security 에서 login 서버를 수행하는 방법이 다양하다
 *
 * DB 와 연동을 하여 로그인을 수행하는 비교적 쉬운 방법으로
 * UserDetailService 상속받아 클래스를 만들고 수행한다
 *
 * UserDetailService uds = new LoginService()
 * uds.loadUserByUsername(username)
 */
public class LoginService implements UserDetailsService {

    private final String encPassword = "$2a$04$znp4YOC8qVGBwfC375P7Iekk9yHy7JfiicmITlBtdUlQJVDRFjYha";
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**
         * 1. Dao 에서 사용자 정보 가져오기
         * username 으로 member table 에서
         * findById(username) 등을 수행하여
         * User 정보를 가져온다
         */

        UserDetailsVO userVO = UserDetailsVO.builder()
                .username("rudgjs8080")
                .password(encPassword)
                .isAccountNonExpired(true)
                .isEnabled(true)
                .isCredentialsNonExpired(true)
                .isAccountNonExpired(true)
                .build();
        /**
         * 2. dao 에서 받은 사용자 정보가 없으면
         * 즉 username 에 저장된 사용자 이름이
         * DB 에 없으면
         * 강제로 exception 을 발생하여
         * security 에게 알려준다
         */

        if(userVO == null){
            // log.debug("{} username 없음", username);
            throw new UsernameNotFoundException(username + " 사용자 없음" );
        }
        // ======================
        // security 에 내장된 코드
//        try {
//            UserDetails vo = loadUserByUsername("rudgjs8080");
//            // 비밀번호를 검사하는 코드가 내장되어 있을 것이다
//        }catch (UsernameNotFoundException e){
//            //
//        }
        // ======================
        return userVO;
    }
}
