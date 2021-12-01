package com.rudgjs8080.security.config.auth;

import com.rudgjs8080.security.model.User;
import com.rudgjs8080.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 시큐리티 설정에서 loginProcessingUrl("login") 으로 걸어놨기 때문에
 * /login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는 loadUserByUsername 함수가 실행
 *
 * 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다
 */
@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    // String username 에서 username 은 form 태그 안에서 name 으로 설정된 값으로 맞춰줘야한다
    // 시큐리티 session(Authentication(내부 UserDetails))
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username);
        if(userEntity!= null){
            return new PrincipalDetails(userEntity);
        }
        return null;
    }
}
