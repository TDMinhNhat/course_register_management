package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.models.postgresql.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course,Long> {
    List<Course> findByDepartment_Id(Long departmentId);
}
