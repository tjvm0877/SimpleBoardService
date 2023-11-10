package com.hyun.simpleboardservice.controller;

import com.hyun.simpleboardservice.dto.PostCreateRequestDto;
import com.hyun.simpleboardservice.dto.PostResponseDto;
import com.hyun.simpleboardservice.dto.PostUpdateRequestDto;
import com.hyun.simpleboardservice.service.PostService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Tag(name = "게시글 API")
@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @Operation(summary = "게시글 조회", description = "id를 통해 게시글 조회")
    @Parameter(name = "id", description = "게시글 id")
    @GetMapping
    public ResponseEntity<PostResponseDto> getPost(@RequestParam Long id) {
        PostResponseDto postResponseDto = postService.getPost(id);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @Operation(summary = "게시글 등록")
    @PostMapping
    public ResponseEntity<PostResponseDto> createPost(@RequestBody PostCreateRequestDto postCreateRequestDto) {
        PostResponseDto postResponseDto = postService.createdPost(postCreateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @Operation(summary = "게시글 수정")
    @PutMapping
    public ResponseEntity<PostResponseDto> updatePost(@RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        PostResponseDto postResponseDto = postService.updatePost(postUpdateRequestDto);
        return ResponseEntity.status(HttpStatus.OK).body(postResponseDto);
    }

    @Operation(summary = "게시글 삭제")
    @DeleteMapping
    public ResponseEntity<String> deletePost(@RequestParam Long id) {
        return ResponseEntity.status(HttpStatus.OK).body("Success");
    }
}
