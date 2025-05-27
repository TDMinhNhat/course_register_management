package dev.skyherobrine.project.backend.dtos;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor @AllArgsConstructor
public class UserDTO {

    @Size(max = 50, message = "First name maximum length is 50 characters!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must contain only letters and not be blank or empty!")
    private String firstName;

    @Size(max = 50, message = "Last name maximum length is 50 characters!")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "Last name must contain only letters and not be blank or empty!")
    private String lastName;

    @NotBlank(message = "Sex is required!")
    private Boolean sex;

    @NotBlank(message = "Birth date is required!")
    private LocalDate birthDate;

    @Size(max = 300, message = "Address maximum length is 300 characters!")
    private String address;

    @NotBlank(message = "Phone number is required!")
    @Pattern(regexp = "^[0-9]{15,25}$", message = "Phone number must be between 15 and 25 digits!")
    private String phone;

    @Email(message = "Email must be a valid email address!")
    @NotBlank(message = "Email is required!")
    @Size(max = 200, message = "Email maximum length is 200 characters!")
    private String email;

    @NotBlank(message = "Password is required!")
    @Size(min = 8, max = 100, message = "Password must be between 8 and 100 characters!")
    private String password;

    @NotBlank(message = "Department ID is required!")
    @Min(value = 1, message = "Department ID must be a positive number!")
    @Max(value = Long.MAX_VALUE, message = "Department ID must be a valid number!")
    private Long departmentId;

    @NotBlank(message = "Role ID is required!")
    @Min(value = 1, message = "Role ID must be a positive number!")
    @Max(value = Long.MAX_VALUE, message = "Role ID must be a valid number!")
    private Long roleId;
}
