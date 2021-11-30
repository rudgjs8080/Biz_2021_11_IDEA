package com.rudgjs8080.security.config.oauth;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    // 구글로부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.toString : " + userRequest.toString());
        System.out.println("getAttributes : " + super.loadUser(userRequest).getAttributes());
        // 구글로그인 버튼 클릭 -> 구글로그인 창 -> 로그인 완료 -> code return (OAuth-Client 라이브러리) ->AccessToken요청
        // userRequest 정보 -> loadUser 함수 호출 -> 구글로부터 회원프로필 받아줌
        System.out.println("userRequest.getClientRegistration : " + userRequest.getClientRegistration()); // registrationId 로 어떤 OAuth로 로그인 했는지 확인

        OAuth2User oAuth2User = super.loadUser(userRequest);
        return super.loadUser(userRequest);
    }
}
