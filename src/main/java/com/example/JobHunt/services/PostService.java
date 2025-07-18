package com.example.JobHunt.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.JobHunt.dtos.PostDto;
import com.example.JobHunt.exceptions.ResourceNotFoundException;
import com.example.JobHunt.mapper.PostMapper;
import com.example.JobHunt.models.Post;
import com.example.JobHunt.repositories.PostRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostRepo postRepo;
    private final PostMapper postMapper;

    // ✅ Get All Posts
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepo.findAll();
        return posts.stream()
                .map(postMapper::dto)
                .collect(Collectors.toList());
    }

    // ✅ Get Post By Id
    public PostDto getPostById(Long id) throws ResourceNotFoundException {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id: " + id));
        return postMapper.dto(post);
    }

    // ✅ Create Post
    public PostDto createPost(PostDto dto) {
        if (postRepo.existsByLink(dto.getLink())) {
            throw new IllegalArgumentException("Post with this link already exists!");
        }

        Post post = postMapper.toEnt(dto);
        Post saved = postRepo.save(post);
        return postMapper.dto(saved);
    }

    // ✅ Delete Post By Id
    public void deletePost(Long id) throws ResourceNotFoundException {
        Post post = postRepo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found to delete"));
        postRepo.delete(post);
    }

    // ✅ Filter by Role
    public List<PostDto> getByRole(String role) {
        List<Post> posts = postRepo.findByRoleContainingIgnoreCase(role);
        return posts.stream().map(postMapper::dto).collect(Collectors.toList());
    }

    // ✅ Filter by Experience
    public List<PostDto> getByExperience(Integer experience) {
        List<Post> posts = postRepo.findByExperienceGreaterThanEqual(experience);
        return posts.stream().map(postMapper::dto).collect(Collectors.toList());
    }
}
