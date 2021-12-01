# Spring Boot Security
* spring security는 시큐리티 세션을 들고 있다
* 원래 서버 자체가 들고 있는 세션안에 시큐리티가 관리하는 세션이 더 있는 것
* 시큐리티가 관리하는 세션에 꼭 들어 갈 수 있는 type 은 Authentication 객체 뿐이다
* 필요할 때 마다 controller 에서 DI를 할 수 있다
* Authentication 안에 들어 갈 수 있는 2가지 type 이 있는데
1. UserDetails -> 일반적인 Login 할 때
2. OAuth2User -> google, naver, facebook ...etc 할 때

## PrincipalDetails 를 만든이유
* security session 에 들어갈 수 있는 객체는 Authentication 타입
* Authentication 안에는 UserDetails, OAuth2User 2가지 객체만 가능
* 그렇기 때문에 PrincipalDetails 에 implements UserDetails 하게 되면
* PrincipalDetails 가 user object 를 가지게됨
* OAuth2User 도 principal implement 하면 합쳐지게 됨

## OAuth2-Client 사용중
* provider -> google, facebook, twitter ... 등의 기본제공자가 있음
* Naver나 kakao는 기본제공자에 없음
* 나라마다 대형포털사이트가 다르기 때문에 & getAttribute 값이 각자 다 다름
* ex) id: 1234~~(facebook), sub: 1234~ (google)
