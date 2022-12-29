package com.jojodu.book.crudservice.service.posts;

import com.jojodu.book.crudservice.domain.posts.PostJpaRepository;
import com.jojodu.book.crudservice.domain.posts.Posts;
import com.jojodu.book.crudservice.web.dto.PostsListResponseDto;
import com.jojodu.book.crudservice.web.dto.PostsResponseDto;
import com.jojodu.book.crudservice.web.dto.PostsSaveRequestDto;
import com.jojodu.book.crudservice.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(readOnly = true)
public class PostsService {
    private final PostJpaRepository postJpaRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postJpaRepository.save(requestDto.toEntity()).getId();

    }

    public PostsResponseDto findById(Long id) {
        Posts posts = postJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다.id=" + id));
        return new PostsResponseDto(posts);

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postJpaRepository
                .findById(id).orElseThrow(() ->
                        new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());
        log.info("posts={}",posts.toString());
        return id;
    }

    public List<PostsListResponseDto> findAllDesc() {
        return postJpaRepository.findAllDesc().stream().map(p -> new PostsListResponseDto(p)).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postJpaRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("등록된 글이 없습니다."));
        postJpaRepository.delete(posts);

    }
}
