package com.example.JobHunt.mapper;

import org.mapstruct.Mapper;

import com.example.JobHunt.dtos.PostDto;
import com.example.JobHunt.models.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {

    PostDto dto(Post post);

    Post toEnt(PostDto dto);

}
