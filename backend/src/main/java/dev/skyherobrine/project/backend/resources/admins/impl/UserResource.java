package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.UserDTO;
import dev.skyherobrine.project.backend.enums.UserStatus;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.User;
import dev.skyherobrine.project.backend.repositories.postgresql.UserRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import dev.skyherobrine.project.backend.services.admins.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/users")
@Slf4j
public class UserResource implements IResources<UserDTO, Long> {

    private final UserRepository userRepository;
    private final UserService userService;

    public UserResource(UserRepository userRepository, UserService userService) {
        this.userRepository = userRepository;
        this.userService = userService;
    }

    @PostMapping
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody UserDTO userDTO) {
        log.info("Admin User: call the api adding new user");
        return ResponseEntity.ok(new Response(
                HttpStatus.CREATED.value(),
                "Adding the new user successfully",
                userService.addUser(userDTO)
        ));
    }

    @Override
    public ResponseEntity<Response> update(UserDTO userDTO, Long aLong) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        log.info("Admin User: call the api deleting user by ID");
        User user = userRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("User not found with ID: " + id));
        user.setStatus(UserStatus.DELETED);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Deleting user by ID successfully",
                userRepository.save(user))
        );
    }

    @GetMapping
    @Override
    public ResponseEntity<Response> getAll() {
        log.info("Admin User: call the api getting all users");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Getting all users successfully",
                userRepository.findAll()
        ));
    }

    @GetMapping("/page")
    @Override
    public ResponseEntity<Response> getALl(
            @Valid
            @Min(value = 0, message = "Page must be a non-negative number")
            @RequestParam Integer page,
            @Valid
            @Min(value = 1, message = "Size must be a positive number")
            @RequestParam Integer size) {
        log.info("Admin User: call the api getting all users with pagination");
        return ResponseEntity.badRequest().body(new Response(
                HttpStatus.BAD_REQUEST.value(),
                "Page and size must be positive numbers",
                userRepository.findAll(Pageable.ofSize(size).withPage(page))
        ));
    }

    @GetMapping("/sort")
    @Override
    public ResponseEntity<Response> getAll(
            @Valid @NotBlank(message = "Sort field is required")
            @RequestParam String sort,
            @Valid
            @Pattern(regexp = "ASC|DESC", message = "Order must be either 'ASC' or 'DESC' and not be blank or empty!")
            @RequestParam String order) {
        log.info("Admin User: call the api getting all users with sorting");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Getting all users successfully with sorting",
                userRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))
        ));
    }

    @GetMapping("/page_and_sort")
    @Override
    public ResponseEntity<Response> getAll(
            @Valid
            @Min(value = 0, message = "Page must be a non-negative number")
            @RequestParam Integer page,
            @Valid
            @Min(value = 1, message = "Size must be a positive number")
            @RequestParam Integer size,
            @Valid @NotBlank(message = "Sort field is required")
            @RequestParam String sort,
            @Valid
            @Pattern(regexp = "ASC|DESC", message = "Order must be either 'ASC' or 'DESC' and not be blank or empty!")
            @RequestParam String order) {
        log.info("Admin User: call the api getting all users with pagination and sorting");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Getting all users successfully with pagination and sorting",
                userRepository.findAll(Pageable.ofSize(size).withPage(page).getSortOr(Sort.by(Sort.Direction.fromString(order), sort)))
        ));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Long id) {
        log.info("Admin User: call the api getting user by ID");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Getting user by ID successfully",
                userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + id))
        ));
    }
}
