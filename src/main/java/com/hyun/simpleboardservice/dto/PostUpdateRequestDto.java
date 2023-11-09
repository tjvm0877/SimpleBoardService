package com.hyun.simpleboardservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PostUpdateRequestDto {
    private Long postId;
    private String postTitle;
    private String postContent;
}
