package com.jojodu.book.crudservice.web.dto;

import com.jojodu.book.crudservice.domain.posts.Posts;
import lombok.Data;

@Data
public class PostsResponseDto {
    private Long id;

    private String title;

    private String content;

    private String author;

    public PostsResponseDto(Posts posts) {
        this.id = posts.getId();
        this.title = posts.getTitle();
        this.content = posts.getContent();
        this.author = posts.getAuthor();

    }
}
