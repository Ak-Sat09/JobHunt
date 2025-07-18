package com.example.JobHunt.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JobHunt.models.Post;

public interface PostRepo extends JpaRepository<Post, Long> {

    List<Post> findByRoleContainingIgnoreCase(String role);

    List<Post> findByExperienceGreaterThanEqual(Integer experience);

    boolean existsByLink(String link);

}
