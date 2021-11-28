package com.rudgjs8080.book.web;

import com.rudgjs8080.book.service.posts.PostsSerevice;
import com.rudgjs8080.book.web.dto.PostsResponseDto;
import com.rudgjs8080.book.web.dto.PostsSaveRequestDto;
import com.rudgjs8080.book.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsSerevice postsSerevice;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsSerevice.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsSerevice.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsSerevice.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsSerevice.delete(id);
        return id;
    }
}
