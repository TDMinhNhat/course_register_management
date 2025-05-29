package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.DepartmentDTO;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import dev.skyherobrine.project.backend.repositories.postgresql.DepartmentRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/departments")
@Slf4j
public class DepartmentResource implements IResources<DepartmentDTO,Long> {

    private final DepartmentRepository departmentRepository;

    public DepartmentResource(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody DepartmentDTO request) {
        log.info("Admin Department: call the api adding the department");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Department added successfully",
                departmentRepository.save(request.toObject())
        ));
    }

    @Override
    public ResponseEntity<Response> update(DepartmentDTO departmentDTO, Long aLong) {
        return null;
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<Response> delete(@PathVariable Long id) {
        log.info("Admin Department: call the api deleting the department with id {}", id);
        Department department = departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id));
        department.setStatus(false);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Department deleted successfully",
                departmentRepository.save(department)
        ));
    }

    @GetMapping("/")
    @Override
    public ResponseEntity<Response> getAll() {
        log.info("Admin Department: call the api getting all departments");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Departments retrieved successfully",
                departmentRepository.findAll()
        ));
    }

    @GetMapping("/page")
    @Override
    public ResponseEntity<Response> getALl(
            @Valid @Min(value = 1, message = "Page number must be greater than or equal to 1")
            @RequestParam Integer page,
            @Valid @Min(value = 1, message = "Size must be greater than or equal to 1")
            @RequestParam Integer size) {
        log.info("Admin Department: call the api getting all departments with paging");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Departments retrieved successfully",
                departmentRepository.findAll(PageRequest.of(page - 1, size))
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
        log.info("Admin Department: call the api getting all departments with sorting");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Departments retrieved successfully with sorting",
                departmentRepository.findAll(Sort.by(Sort.Direction.fromString(order), sort))
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
        log.info("Admin Department: call the api getting all departments with paging and sorting");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Departments retrieved successfully with paging and sorting",
                departmentRepository.findAll(PageRequest.of(page - 1, size, Sort.by(Sort.Direction.fromString(order), sort)))
        ));
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Response> getById(@PathVariable Long id) {
        log.info("Admin Department: call the api getting department by id {}", id);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Department retrieved successfully",
                departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Department not found with id: " + id))
        ));
    }
}
