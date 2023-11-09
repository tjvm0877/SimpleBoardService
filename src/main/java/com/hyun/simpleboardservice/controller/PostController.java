package com.hyun.simpleboardservice.controller;

import com.hyun.simpleboardservice.dto.PostCreateRequestDto;
import com.hyun.simpleboardservice.dto.PostResponseDto;
import com.hyun.simpleboardservice.dto.PostUpdateRequestDto;
import com.hyun.simpleboardservice.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping
    public ResponseEntity<PostResponseDto> getPost(@RequestParam Long id) {
        PostResponseDto postResponseDto = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
        PostResponseDto postResponseDto = postService.createdPost(postCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @PutMapping
    public ResponseEntity<PostResponseDto> updatePost(@RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        PostResponseDto postResponseDto = postService.updatePost(postUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
