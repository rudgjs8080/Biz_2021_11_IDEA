# Spring Boot Security
* spring security는 시큐리티 세션을 들고 있다
* 원래 서버 자체가 들고 있는 세션안에 시큐리티가 관리하는 세션이 더 있는 것
* 시큐리티가 관리하는 세션에 꼭 들어 갈 수 있는 type 은 Authentication 객체 뿐이다
* 필요할 때 마다 controller 에서 DI를 할 수 있다
* Authentication 안에 들어 갈 수 있는 2가지 type 이 있는데
1. UserDetails -> 일반적인 Login 할 때
2. OAuth2User -> google, naver, facebook ...etc 할 때
* 