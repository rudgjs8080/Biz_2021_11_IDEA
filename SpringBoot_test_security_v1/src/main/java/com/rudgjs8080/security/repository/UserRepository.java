package com.rudgjs8080.security.repository;

import com.rudgjs8080.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * CRUD 함수를 JpaRepository가 들고 있음
 * @Repository 라는 어노테이션이 없어도 IoC 가 된다 이유는 JpaRepository를 상속했기 때문에
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    // findBy 규칙 => Username 문법
    // select * from user where username = (username)
    public User findByUsername(String username); // Jpa query method 검색해서 찾아볼 수 있음


}
