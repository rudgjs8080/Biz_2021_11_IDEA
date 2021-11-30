package com.rudgjs8080.security.config;

import com.rudgjs8080.security.config.oauth.PrincipalOauth2UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true) // secured 어노테이션 활성화, preAuthorize와 postAuthorize 라는 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 해당 메서드의 리턴되는 오브젝트를 IoC로 등록해준다
     *
     * .loginProcessingUrl("/login") 을 설정하게 되면
     * /login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행한다
     * 그렇기 때문에 Controller 에 /login 을 만들필요가 없다다
     *
     * .defaultSuccessUrl을 설정하게 되면
     * 로그인 완료됐을때 이동하게 될 페이지
     * /loginForm 에서 로그인을 하면 "/" 로 보내줄건데
     * 특정 page 에서 login 을 시도 하면 로그인 성공시 바로 그 page 로 보내준다
     *
     * 구글 로그인이 완료된 뒤의 후처리가 필요함 1. 코드받기(인증), 2. 엑세스토큰(권한),
     * 3. 사용자프로필 정보를 가져와서, 4. 그 정보를 토대로 회원가입을 자동으로 진행시키기도 하고
     *
     * */

    @Autowired
    private PrincipalOauth2UserService principalOauth2UserService;
    @Bean
    public BCryptPasswordEncoder endcodePwd(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/user/**").authenticated() // 인증만 되면 들어갈 수 있는 주소
                .antMatchers("/manager/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_MANAGER')")
                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
                .anyRequest().permitAll()
                .and()
                .formLogin()
                .loginPage("/loginForm")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/")
                .and()
                .oauth2Login()
                .loginPage("/loginForm")
                .userInfoEndpoint()
                .userService(principalOauth2UserService);
    }


}
