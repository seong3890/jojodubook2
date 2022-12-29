package com.jojodu.book.crudservice.web.dto;

import com.jojodu.book.crudservice.domain.posts.Posts;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PostsListResponseDto {
    private Long id;

    private String title;

    private String author;

    private LocalDateTime modifiedDate;

    public PostsListResponseDto(Posts p) {
        this.id = p.getId();
        this.title = p.getTitle();
        this.author = p.getAuthor();
        this.modifiedDate = p.getModifyDate();
    }
}
