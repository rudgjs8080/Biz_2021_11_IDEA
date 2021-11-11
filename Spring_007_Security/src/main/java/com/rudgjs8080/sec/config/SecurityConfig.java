package com.rudgjs8080.sec.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .anyRequest().authenticated();
        http.formLogin();
        http.csrf().csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
        /**
         * spring Security 에서 form 으로 데이터를 전송할 때
         * 보통 POST 로 전송을 하는데
         * POST로 전송을 할때는 반드시 ..csrf.token 값을
         * 데이터에 포함하여 전송을 해야한다
         *
         * form을 만들 때 ,jsp, thymeleaf 등의 taglibs 등을 사용하면
         * 자동으로 csrf.token 을 form 에 포함시키는 코드를 만들어 준다
         *
         * 최근 spring security 정책이
         * https( Hyper Text Transfer protocol security)
         * 정상적으로 csrf.token 을 form 에 추가를 한다
         *
         * 그런데 http 로 되어있는 곳에는 정상적으로 추가하지 않는다
         *
         * http 로 테스트를 하는 경우는 아래 속성을 추가해 줘야 한다
         */
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("rudgjs8080")
                .password("{noop}1234")
                .roles("ADMIN");
    }
}
