package com.hyun.simpleboardservice.service.impl;

import com.hyun.simpleboardservice.dto.PostCreateRequestDto;
import com.hyun.simpleboardservice.dto.PostResponseDto;
import com.hyun.simpleboardservice.dto.PostUpdateRequestDto;
import com.hyun.simpleboardservice.entity.Post;
import com.hyun.simpleboardservice.repository.PostRepository;
import com.hyun.simpleboardservice.service.PostService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostResponseDto createdPost(PostCreateRequestDto postRequestDto) {
        Post newPost = Post.builder()
                .postTitle(postRequestDto.getPostTitle())
                .postContent(postRequestDto.getPostContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
        postRepository.save(newPost);

        return PostResponseDto.builder()
                .postId(newPost.getPostId())
                .postTitle(newPost.getPostTitle())
                .postContent(newPost.getPostContent())
                .build();
    }

    @Override
    public PostResponseDto getPost(Long id) {
        Post foundPost = postRepository.findById(id).orElseThrow(
                () -> new NullPointerException()
        );

        return PostResponseDto.builder()
                .postId(foundPost.getPostId())
                .postTitle(foundPost.getPostTitle())
                .postContent(foundPost.getPostContent())
                .build();
    }
    @Override
    public PostResponseDto updatePost(PostUpdateRequestDto postUpdateRequestDto) {
        Post foundPost = postRepository.findById(postUpdateRequestDto.getPostId())
                .orElseThrow(
                        () -> new RuntimeException()
                );

        foundPost.updatePost(postUpdateRequestDto.getPostTitle(), postUpdateRequestDto.getPostContent());
        postRepository.save(foundPost);

        return PostResponseDto.builder()
                .postId(foundPost.getPostId())
                .postTitle(foundPost.getPostTitle())
                .postContent(foundPost.getPostContent())
                .build();
    }

    @Override
    public void deletePost(Long id) {
    }
}
