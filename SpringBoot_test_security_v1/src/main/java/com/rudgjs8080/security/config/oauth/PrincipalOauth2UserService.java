package com.rudgjs8080.security.config.oauth;

import com.rudgjs8080.security.config.auth.PrincipalDetails;
import com.rudgjs8080.security.config.oauth.provider.FacebookInfo;
import com.rudgjs8080.security.config.oauth.provider.GoogleUserInfo;
import com.rudgjs8080.security.config.oauth.provider.NaverUserInfo;
import com.rudgjs8080.security.config.oauth.provider.OAuth2UserInfo;
import com.rudgjs8080.security.model.User;
import com.rudgjs8080.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {

    @Autowired
    private UserRepository userRepository;

    // 구글로부터 받은 userRequest 데이터에 대한 후처리 되는 함수
    // 함수 종료시 @AuthenticationPrincipal 어노테이션이 만들어진다
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        System.out.println("userRequest.getClientRegistration : " + userRequest.getClientRegistration()); // registrationId 로 어떤 OAuth로 로그인 했는지 확인

        OAuth2User oAuth2User = super.loadUser(userRequest);
        // 구글로그인 버튼 클릭 -> 구글로그인 창 -> 로그인 완료 -> code return (OAuth-Client 라이브러리) ->AccessToken요청
        // userRequest 정보 -> loadUser 함수 호출 -> 구글로부터 회원프로필 받아줌
        // oAuth2User 와 super.loadUser(userRequest) 는 같다
        System.out.println("getAttributes : " + oAuth2User.getAttributes());

        OAuth2UserInfo oAuth2UserInfo = null;
        if(userRequest.getClientRegistration().getRegistrationId().equals("google")){
            System.out.println("구글 로그인 요청");
            oAuth2UserInfo = new GoogleUserInfo(oAuth2User.getAttributes());
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("facebook")){
            System.out.println("페이스북 로그인 요청");
            oAuth2UserInfo = new FacebookInfo(oAuth2User.getAttributes());
        } else if(userRequest.getClientRegistration().getRegistrationId().equals("naver")){
            System.out.println("네이버 로그인 요청");
            oAuth2UserInfo = new NaverUserInfo((Map)oAuth2User.getAttributes().get("response"));
        }
        else {
            System.out.println("구글과 페이스북만 지원함");
        }


        String provider = oAuth2UserInfo.getProvider();
        String providerId = oAuth2UserInfo.getProviderId();
        String username = provider + "_" + providerId;
        String email = oAuth2UserInfo.getEmail();
        String role = "ROLE_USER";

        User userEntity = userRepository.findByUsername(username);
        if(userEntity == null){
            System.out.println("최초 로그인 입니다");
            userEntity =User.builder()
                    .username(username)
                    .email(email)
                    .role(role)
                    .provider(provider)
                    .providerId(providerId)
                    .build();
            userRepository.save(userEntity);
        }



        // return 을 하게되면 PrincipalDetails를 만들어서 Authentication 에 들어가게 될 것
        return new PrincipalDetails(userEntity, oAuth2User.getAttributes());
    }
}
