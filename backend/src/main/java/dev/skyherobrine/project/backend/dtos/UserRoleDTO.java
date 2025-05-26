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

    @NotBlank(message = "The role name can't be blank or empty")
    @Size(max = 100, message = "The role name maximum length is 100 characters")
    @Pattern(regexp = "^[a-zA-Z_]+$", message = "The role name can only contain characters and underscores")
    private String roleName;

    @Size(max = 500, message = "The description maximum length is 500 characters")
    private String description;

    public UserRole toObject() {
        return new UserRole(roleName, description);
    }
}
