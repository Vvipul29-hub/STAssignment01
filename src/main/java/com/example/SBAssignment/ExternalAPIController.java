package com.example.SBAssignment;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/external")
@RequiredArgsConstructor
public class ExternalAPIController {
    private final ExternalAPIService externalAPIService;

    @GetMapping("/posts")
    public List<PostResponse> getExternalData() {
        return externalAPIService.getPosts();
    }
}
