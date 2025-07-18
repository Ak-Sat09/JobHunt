package com.example.JobHunt.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {

    @NotBlank(message = "CompanyName is required")
    @Size(max = 100)
    private String name;

    @NotBlank(message = "Role is required")
    @Size(max = 100)
    private String role;

    @Min(value = 0, message = "Experience must be positive")
    private Integer experience;

    @NotBlank(message = "Apply link is required")
    @Size(max = 255)

    private String link;
}
