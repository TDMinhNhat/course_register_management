package dev.skyherobrine.project.backend.dtos;

import dev.skyherobrine.project.backend.models.postgresql.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserRoleDTO {

    @Size(max = 100, message = "The role name maximum length is 100 characters")
    @Pattern(regexp = "^[a-zA-Z_]+$", message = "The role name must be contain characters, underscores and not empty of blank")
    private String roleName;

    @Size(max = 500, message = "The description maximum length is 500 characters")
    private String description;

    public UserRole toObject() {
        return new UserRole(roleName, description);
    }
}
