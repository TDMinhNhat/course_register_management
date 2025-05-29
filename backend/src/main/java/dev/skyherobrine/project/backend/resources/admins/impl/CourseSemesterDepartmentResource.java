package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.CourseSemesterDepartmentDTO;
import dev.skyherobrine.project.backend.keys.CourseSemesterDepartmentKey;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.CourseSemesterDepartment;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseSemesterDepartmentRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import dev.skyherobrine.project.backend.services.admins.CourseSemesterDepartmentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/course_semester_department")
@Slf4j
public class CourseSemesterDepartmentResource implements IResources<CourseSemesterDepartmentDTO, CourseSemesterDepartmentKey> {

    private final CourseSemesterDepartmentService courseSemesterDepartmentService;
    private final CourseSemesterDepartmentRepository courseSemesterDepartmentRepository;

    public CourseSemesterDepartmentResource(CourseSemesterDepartmentService courseSemesterDepartmentService, CourseSemesterDepartmentRepository courseSemesterDepartmentRepository) {
        this.courseSemesterDepartmentService = courseSemesterDepartmentService;
        this.courseSemesterDepartmentRepository = courseSemesterDepartmentRepository;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody CourseSemesterDepartmentDTO request) {
        log.info("Admin CourseSemesterDepartment: call the api add CourseSemesterDepartment");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "CourseSemesterDepartment added successfully",
                courseSemesterDepartmentService.addCourseSemesterDepartment(request)
        ));
    }

    @Override
    public ResponseEntity<Response> update(CourseSemesterDepartmentDTO courseSemesterDepartmentDTO, CourseSemesterDepartmentKey courseSemesterDepartmentKey) {
        return null;
    }

    @Override
    public ResponseEntity<Response> delete(CourseSemesterDepartmentKey courseSemesterDepartmentKey) {
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
    public ResponseEntity<Response> getById(CourseSemesterDepartmentKey courseSemesterDepartmentKey) {
        return null;
    }
}
