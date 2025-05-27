package dev.skyherobrine.project.backend.services.admins;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import dev.skyherobrine.project.backend.models.postgresql.User;
import dev.skyherobrine.project.backend.models.postgresql.UserRole;
import dev.skyherobrine.project.backend.repositories.postgresql.DepartmentRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.UserRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.UserRoleRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final DepartmentRepository departmentRepository;

    public UserService(UserRepository userRepository, UserRoleRepository userRoleRepository, DepartmentRepository departmentRepository) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.departmentRepository = departmentRepository;
    }

    public User addUser(UserDTO request) {
        log.info("Admin User - Service: Adding new user");
        UserRole userRole = userRoleRepository.findById(request.getRoleId()).orElseThrow(() -> new EntityNotFoundException("Role not found with ID: " + request.getRoleId()));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + request.getDepartmentId()));

        User user = new User(
            request.getFirstName(),
            request.getLastName(),
            request.getSex(),
            request.getBirthDate(),
            request.getAddress(),
            request.getPhone(),
            request.getEmail(),
            request.getPassword(),
            department,
            userRole
        );

        return userRepository.save(user);
    }
}
