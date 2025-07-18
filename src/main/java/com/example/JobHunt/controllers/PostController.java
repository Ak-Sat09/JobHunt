package com.example.JobHunt.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.JobHunt.dtos.PostDto;
import com.example.JobHunt.exceptions.ResourceNotFoundException;
import com.example.JobHunt.services.PostService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // Get all posts
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = postService.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    // Get post by id
    @GetMapping("/{id}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Long id) throws ResourceNotFoundException {
        PostDto post = postService.getPostById(id);
        return ResponseEntity.ok(post);
    }

    // Create new post
    @PostMapping
    public ResponseEntity<PostDto> createPost(@jakarta.validation.Valid @RequestBody PostDto dto) {
        PostDto createdPost = postService.createPost(dto);
        return new ResponseEntity<>(createdPost, HttpStatus.CREATED);
    }

    // Delete post by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id) throws ResourceNotFoundException {
        postService.deletePost(id);
        return ResponseEntity.noContent().build();
    }

    // Filter posts by role
    @GetMapping("/role/{role}")
    public ResponseEntity<List<PostDto>> getByRole(@PathVariable String role) {
        List<PostDto> posts = postService.getByRole(role);
        return ResponseEntity.ok(posts);
    }

    // Filter posts by experience
    @GetMapping("/experience/{experience}")
    public ResponseEntity<List<PostDto>> getByExperience(@PathVariable Integer experience) {
        return ResponseEntity.ok(postService.getByExperience(experience));
    }

}
