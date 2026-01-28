package com.example.SBAssignment;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonPropertyOrder({"userId", "id", "title", "body"})
@Getter @Setter @NoArgsConstructor
public class PostResponse {
    private Long userId;
    private Long id;
    private String title;
    private String body;
}
