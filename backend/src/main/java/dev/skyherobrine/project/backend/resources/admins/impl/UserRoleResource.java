package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.UserRoleDTO;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.UserRole;
import dev.skyherobrine.project.backend.repositories.postgresql.UserRoleRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admins/user_roles")
@Slf4j
public class UserRoleResource implements IResources<UserRoleDTO, Long> {

    private final UserRoleRepository userRoleRepository;

    public UserRoleResource(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody UserRoleDTO request) {
        log.info("Admin User Role: call the api add user role");
        return ResponseEntity.ok(new Response(
                HttpStatus.CREATED.value(),
                "Add the user role successfully",
                userRoleRepository.save(request.toObject())
        ));
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response> update(@Valid @RequestBody UserRoleDTO request, @PathVariable("id") Long id) {
        log.info("Admin User Role: call the api update user role");
        UserRole role = userRoleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The user role wasn't found with id: " + id));
        role.setRoleName(request.getRoleName());
        role.setDescription(request.getDescription());
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Update the user role successfully",
                userRoleRepository.save(role)
        ));
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable("id") Long id) {
        log.info("Admin User Role: call the api delete user role with id {}", id);
        UserRole role = userRoleRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The user role wasn't found with id: " + id));
        userRoleRepository.delete(role);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Delete the user role successfully",
                null
        ));
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Response> getAll() {
        log.info("Admin User Role: call the api get all user roles");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all the user roles successfully",
                userRoleRepository.findAll()
        ));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> getById(@PathVariable("id") Long id) {
        log.info("Admin User Role: call the api get user role by id {}", id);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get the user role successfully",
                userRoleRepository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("User role not found with id: " + id))
        ));
    }

    @Override
    public ResponseEntity<Response> getALl(Integer page, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<Response> getAll(String sort, String order) {
        return null;
    }

    @Override
    public ResponseEntity<Response> getAll(Integer page, Integer size, String sort, String order) {
        return null;
    }
}
