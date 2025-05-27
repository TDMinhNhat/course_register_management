package dev.skyherobrine.project.backend.services.admins;

import dev.skyherobrine.project.backend.dtos.CoursePriorityDTO;
import dev.skyherobrine.project.backend.keys.CoursePriorityKey;
import dev.skyherobrine.project.backend.models.postgresql.Course;
import dev.skyherobrine.project.backend.models.postgresql.CoursePriority;
import dev.skyherobrine.project.backend.models.postgresql.Department;
import dev.skyherobrine.project.backend.repositories.postgresql.CoursePriorityRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.CourseRepository;
import dev.skyherobrine.project.backend.repositories.postgresql.DepartmentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CoursePriorityService {

    private final CourseRepository courseRepository;
    private final CoursePriorityRepository coursePriorityRepository;
    private final DepartmentRepository departmentRepository;

    public CoursePriorityService(CourseRepository courseRepository, CoursePriorityRepository coursePriorityRepository, DepartmentRepository departmentRepository) {
        this.courseRepository = courseRepository;
        this.coursePriorityRepository = coursePriorityRepository;
        this.departmentRepository = departmentRepository;
    }

    public CoursePriority addCoursePriority(CoursePriorityDTO request) {
        Course main = courseRepository.findById(request.getCourseMain()).orElseThrow(() -> new EntityNotFoundException("The course main id " + request.getCourseMain() + " does not exist"));
        Course needed = courseRepository.findById(request.getCourseNeeded()).orElseThrow(() -> new EntityNotFoundException("The course needed id " + request.getCourseNeeded() + " does not exist"));
        Department department = departmentRepository.findById(request.getDepartmentId()).orElseThrow(() -> new EntityNotFoundException("The department id " + request.getDepartmentId() + " does not exist"));

        CoursePriority coursePriority = new CoursePriority(
                new CoursePriorityKey(main, needed),
                request.getDescription(),
                department
        );

        return coursePriorityRepository.save(coursePriority);
    }
}
