package com.jojodu.book.crudservice.web.controller;

import com.jojodu.book.crudservice.service.posts.PostsService;
import com.jojodu.book.crudservice.web.dto.PostsListResponseDto;
import com.jojodu.book.crudservice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class IndexController {
    private final PostsService postsService;

    @GetMapping("/")
    public String index(Model model) {
        List<PostsListResponseDto> posts = postsService.findAllDesc();
        model.addAttribute("posts", posts);
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts/save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable("id") Long id, Model model) {
        PostsResponseDto findPosts = postsService.findById(id);
        model.addAttribute("posts", findPosts);
        return "posts/posts-update";

    }
}
