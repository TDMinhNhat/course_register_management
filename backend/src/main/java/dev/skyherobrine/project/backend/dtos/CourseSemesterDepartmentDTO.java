package dev.skyherobrine.project.backend.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class CourseSemesterDepartmentDTO {

    @NotBlank(message = "Semester cannot be blank or null")
    @Min(value = 1, message = "Semester must be 1, 2 or 3")
    @Max(value = 3, message = "Semester must be 1, 2 or 3")
    private Integer semester;

    @NotBlank(message = "Course ID cannot be blank or null")
    @Min(value = 1, message = "Course ID must be a positive number")
    private Long courseId;

    @NotBlank(message = "Department ID cannot be blank or null")
    @Min(value = 1, message = "Department ID must be a positive number")
    private Long departmentId;

    @NotBlank(message = "Optional field cannot be blank or null")
    private Boolean optional;
}
