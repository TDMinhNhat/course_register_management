package dev.skyherobrine.project.backend.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CourseDTO {

    @Size(max = 150, message = "Course name maximum length is 150 characters")
    @Pattern(regexp = "^[a-zA-Z0-9\\s]+$", message = "Course name can only contain alphanumeric characters, spaces and must not be empty or null")
    private String courseName;

    @Size(max = 1000, message = "Description maximum length is 1000 characters")
    private String description;

    @Min(value = 2, message = "Credits must be at least 2")
    @NotBlank(message = "Credits must not be blank or null")
    private Integer credits;

    @Min(value = 1, message = "Department ID must be at least 1")
    @NotBlank(message = "Department ID must not be blank or null")
    private Long departmentId;
}
