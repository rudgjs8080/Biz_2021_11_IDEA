package com.rudgjs8080.security.config.auth;

import com.rudgjs8080.security.model.User;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * 시큐리티가 /login 주소를 낚아채서 로그인을 진행시킴
 * 로그인을 진행이 완료가 되면 시큐리티 session 을 만들어준다 (Security ContextHolder)에다가 세션 정보를 저장?
 * 이 시큐리티가 가지고 있는 세션에 들어갈 수 있는 Object 는 정해져 있다
 * Authentication type의 객체
 * Authentication 안에 User 정보가 있어야 된다
 * User Object 의 type 은 UserDetails type 객체어야 한다
 *
 * Security Session => Authentication => UserDetails(PrincipalDetails)
 *
 */
@Getter
public class PrincipalDetails implements UserDetails, OAuth2User {

    private User user; // composition ??

    // 생성자
    public PrincipalDetails(User user){
        this.user = user;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return null;
    }

    /**
     * 해당 User의 권한을 리턴하는 곳
     * ArrayList 는 Collection 의 자식임
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return user.getRole();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    // 계정이 만료됐나
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    // 계정이 잠겼나
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    // 비밀번호 만료됐나
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    // 계정이 활성화 됐나
    @Override
    public boolean isEnabled() {
        // 우리 사이트에서 1년동안 회원이 로그인을 안하면 휴면계정으로 전환되기로 한다면


        return true;
    }

    @Override
    public String getName() {
        return null;
    }
}
