package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.keys.CoursePriorityKey;
import dev.skyherobrine.project.backend.models.postgresql.CoursePriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoursePriorityRepository extends JpaRepository<CoursePriority, CoursePriorityKey> {
    List<CoursePriority> findById_CourseMain_Id(Long idCourseMainId);

    List<CoursePriority> findById_CourseNeeded_Id(Long idCourseNeededId);
}
