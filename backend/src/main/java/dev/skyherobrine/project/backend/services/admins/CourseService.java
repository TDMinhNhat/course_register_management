package dev.skyherobrine.project.backend.services.admins;

import dev.skyherobrine.project.backend.dtos.CourseDTO;
import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourseService {

    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public CourseService(CourseRepository courseRepository, DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    public Course addCourse(CourseDTO request) {
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + request.getDepartmentId()));

        Course course = new Course(
            request.getCourseName(),
            request.getDescription(),
            request.getCredits(),
            department
        );

        return courseRepository.save(course);
    }
}
