package dev.skyherobrine.project.backend.resources.admins.impl;

import dev.skyherobrine.project.backend.dtos.CoursePriorityDTO;
import dev.skyherobrine.project.backend.keys.CoursePriorityKey;
import dev.skyherobrine.project.backend.models.Response;
import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.models.postgresql.CoursePriority;
import dev.skyherobrine.project.backend.repositories.postgresql.CoursePriorityRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseRepository;
import dev.skyherobrine.project.backend.resources.admins.IResources;
import dev.skyherobrine.project.backend.services.admins.CoursePriorityService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@RestController
@RequestMapping("/api/v1/admin/course_priority")
@Slf4j
public class CoursePriorityResource implements IResources<CoursePriorityDTO, CoursePriorityKey> {

    private final CoursePriorityService coursePriorityService;
    private final CourseRepository courseRepository;
    private final CoursePriorityRepository coursePriorityRepository;

    public CoursePriorityResource(CoursePriorityService coursePriorityService, CourseRepository courseRepository, CoursePriorityRepository coursePriorityRepository) {
        this.coursePriorityService = coursePriorityService;
        this.courseRepository = courseRepository;
        this.coursePriorityRepository = coursePriorityRepository;
    }

    @PostMapping("/")
    @Override
    public ResponseEntity<Response> add(@Valid @RequestBody CoursePriorityDTO request) {
        log.info("Admin Course Priority: call the api add course priority");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Course priority added successfully",
                coursePriorityService.addCoursePriority(request)
        ));
    }

    @PostMapping("/list")
    public ResponseEntity<Response> addList(@Valid @RequestBody CoursePriorityDTO[] request) {
        log.info("Admin Course Priority: call the api add list of course priority");
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Course priorities added successfully",
                Arrays.stream(request).map(item -> coursePriorityService.addCoursePriority(item)).toList()
        ));
    }

    @Override
    public ResponseEntity<Response> update(CoursePriorityDTO coursePriorityDTO, CoursePriorityKey coursePriorityKey) {
        return null;
    }

    @DeleteMapping
    @Override
    public ResponseEntity<Response> delete(@RequestBody CoursePriorityKey id) {
        log.info("Admin Course Priority: call the api delete course priority");
        Course main = courseRepository.findById(id.getCourseMain().getId()).orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + id.getCourseMain().getId()));
        Course needed = courseRepository.findById(id.getCourseNeeded().getId()).orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + id.getCourseNeeded().getId()));

        CoursePriority coursePriority = coursePriorityRepository.findById(new CoursePriorityKey(main, needed)).orElseThrow(() -> new EntityNotFoundException("Course priority not found with ID: " + id.getCourseMain().getId() + " and " + id.getCourseNeeded().getId()));
        coursePriority.setStatus(false);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Course priority deleted successfully",
                coursePriorityRepository.save(coursePriority)
        ));
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
    public ResponseEntity<Response> getById(CoursePriorityKey coursePriorityKey) {
        return null;
    }

    @GetMapping("/course_main/{courseMainId}")
    public ResponseEntity<Response> getCoursePriorityByMainCourse(@PathVariable Long courseMainId) {
        log.info("Admin Course Priority: call the api get course priority by main course ID: {}", courseMainId);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Course priority retrieved successfully",
                coursePriorityRepository.findById_CourseMain_Id(courseMainId)
        ));
    }

    @GetMapping("/course_needed/{courseNeededId}")
    public ResponseEntity<Response> getCoursePriorityByCourseNeeded(@PathVariable Long courseNeededId) {
        log.info("Admin Course Priority: call the api get course priority by needed course ID: {}", courseNeededId);
        return ResponseEntity.ok(new Response(
                HttpStatus.OK.value(),
                "Course priority retrieved successfully",
                coursePriorityRepository.findById_CourseNeeded_Id((courseNeededId))
        ));
    }
}
