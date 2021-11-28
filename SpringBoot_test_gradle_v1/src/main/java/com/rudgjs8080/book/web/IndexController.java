package com.rudgjs8080.book.web;

import com.rudgjs8080.book.service.posts.PostsSerevice;
import com.rudgjs8080.book.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsSerevice postsSerevice;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsSerevice.findAllDesc());
        return "index";
    }
    @GetMapping("/posts/save")
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsSerevice.findById(id);
        model.addAttribute("post", dto);

        return "posts-update";
    }
}
