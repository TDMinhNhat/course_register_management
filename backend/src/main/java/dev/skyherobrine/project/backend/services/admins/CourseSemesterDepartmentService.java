package dev.skyherobrine.project.backend.services.admins;

import dev.skyherobrine.project.backend.dtos.CourseSemesterDepartmentDTO;
import dev.skyherobrine.project.backend.keys.CourseSemesterDepartmentKey;
import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.models.postgresql.CourseSemesterDepartment;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseSemesterDepartmentRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CourseSemesterDepartmentService {

    private final CourseSemesterDepartmentRepository courseSemesterDepartmentRepository;
    private final CourseRepository courseRepository;
    private final DepartmentRepository departmentRepository;

    public CourseSemesterDepartmentService(CourseSemesterDepartmentRepository courseSemesterDepartmentRepository, CourseRepository courseRepository, DepartmentRepository departmentRepository) {
        this.courseSemesterDepartmentRepository = courseSemesterDepartmentRepository;
        this.courseRepository = courseRepository;
        this.departmentRepository = departmentRepository;
    }

    public CourseSemesterDepartment addCourseSemesterDepartment(CourseSemesterDepartmentDTO request) {
        log.info("Adding CourseSemesterDepartment with request: {}", request);
        Course getCourse = courseRepository.findById(request.getCourseId()).orElseThrow(() -> new EntityNotFoundException("Course not found with ID: " + request.getCourseId()));
        Department getDepartment = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("Department not found with ID: " + request.getDepartmentId()));

        CourseSemesterDepartment courseSemesterDepartment = new CourseSemesterDepartment(
                new CourseSemesterDepartmentKey(request.getSemester(), getCourse, getDepartment),
                request.getOptional()
        );

        return courseSemesterDepartmentRepository.save(courseSemesterDepartment);
    }
}
