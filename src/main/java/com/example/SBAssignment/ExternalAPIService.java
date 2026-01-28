package com.example.SBAssignment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExternalAPIService {
    private final WebClient webClient;

    public List<PostResponse> getPosts() {
        return webClient.get().uri("https://jsonplaceholder.typicode.com/posts").retrieve().bodyToFlux(PostResponse.class).collectList().block();
    }
}
