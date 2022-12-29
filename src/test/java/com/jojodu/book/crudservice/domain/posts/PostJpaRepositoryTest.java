package com.jojodu.book.crudservice.domain.posts;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class PostJpaRepositoryTest {
    @Autowired
    PostJpaRepository postJpaRepository;

    //트랜잭션으로 롤백하기 때문에 사용은 안 하겠다.
    @AfterEach
    @Disabled
    public void cleanup() {
        postJpaRepository.deleteAll();
    }

    @Test
    void 게시글_저장_불러오기() {
        String title = "테시트 게시글";
        String content = "테스트 본문";

        postJpaRepository.save(Posts.builder()
                .title(title)
                .content(content)
                .author("joojojo@naver.com")
                .build());

        List<Posts> postsList = postJpaRepository.findAll();

        Posts posts = postsList.get(0);
//        Assertions.assertThat(posts.getTitle()).isEqualTo(postsList.get(0).getTitle());
        Assertions.assertThat(posts.getTitle()).isEqualTo(title);
    }
}