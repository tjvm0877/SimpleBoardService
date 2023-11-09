package com.hyun.simpleboardservice.service;

import com.hyun.simpleboardservice.dto.PostCreateRequestDto;
import com.hyun.simpleboardservice.dto.PostResponseDto;
import com.hyun.simpleboardservice.dto.PostUpdateRequestDto;

public interface PostService {

    PostResponseDto createdPost(PostCreateRequestDto postRequestDto);

    PostResponseDto getPost(Long id);

    PostResponseDto updatePost(PostUpdateRequestDto postUpdateRequestDto);

    void deletePost(Long id);
}
