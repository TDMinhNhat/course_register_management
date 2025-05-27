package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.CourseDTO;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import dev.skyherobrine.project.backend.services.admins.CourseService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/courses")
@Slf4j
public class CourseResource implements IResources<CourseDTO,Long> {

    private final CourseService courseService;
    private final CourseRepository courseRepository;

    public CourseResource(CourseService courseService, CourseRepository courseRepository) {
        this.courseService = courseService;
        this.courseRepository = courseRepository;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody CourseDTO request) {
        log.info("Admin Course: call the api add the course");
        return ResponseEntity.ok(new Response(
                HttpStatus.CREATED.value(),
                "Course created successfully",
                courseService.addCourse(request)
        ));
    }

    @PostMapping("/list")
    public ResponseEntity<Response> addList(@Valid @RequestBody CourseDTO[] request) {
        log.info("Admin Course: call the api add the list of courses");
        for (CourseDTO courseDTO : request) {
            courseService.addCourse(courseDTO);
        }
        return ResponseEntity.ok(new Response(
                HttpStatus.CREATED.value(),
                "Courses created successfully",
                null
        ));
    }

    @Override
    public ResponseEntity<Response> update(CourseDTO courseDTO, Long aLong) {
        return null;
    }

    @Override
    public ResponseEntity<Response> delete(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Response> getAll() {
        return null;
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

    @Override
    public ResponseEntity<Response> getById(Long aLong) {
        return null;
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<Response> getAllByDepartment(
            @Valid @Min(value = 1, message = "Department ID must be at least 1")
            @PathVariable Long departmentId) {
        log.info("Admin Course: call the api get all courses by department ID: {}", departmentId);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Get all courses by department",
                courseRepository.findByDepartment_Id(departmentId)
        ));
    }
}
