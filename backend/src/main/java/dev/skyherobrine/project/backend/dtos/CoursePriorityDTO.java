package dev.skyherobrine.project.backend.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CoursePriorityDTO {

    @Min(value = 1, message = "Course main ID must be greater than 0")
    @NotBlank(message = "Course main ID cannot be blank")
    private Long courseMain;

    @Min(value = 1, message = "Course needed ID must be greater than 0")
    @NotBlank(message = "Course needed ID cannot be blank")
    private Long courseNeeded;

    @Size(max = 1000, message = "Description maximum length is 1000 characters")
    private String description;

    @Min(value = 1, message = "Department ID must be greater than 0")
    @NotBlank(message = "Department ID cannot be blank")
    private Long departmentId;
}
