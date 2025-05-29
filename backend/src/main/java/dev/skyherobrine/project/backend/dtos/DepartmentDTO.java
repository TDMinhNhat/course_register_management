package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.postgresql.Department;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class DepartmentDTO {

    @Size(max = 50, message = "Short name maximum length is 50 characters")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Short name contains only letters and must not be empty or null")
    private String shortName;

    @Size(max = 200, message = "Full name maximum length is 100 characters")
    @Pattern(regexp = "^[a-zA-Z\\s]+$", message = "Full name contains only letters and spaces and must not be empty or null")
    private String fullName;

    public Department toObject() {
        return new Department(shortName, fullName);
    }
}
