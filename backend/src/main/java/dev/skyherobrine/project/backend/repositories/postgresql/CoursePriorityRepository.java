package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.keys.CoursePriorityKey;
import dev.skyherobrine.project.backend.models.postgresql.CoursePriority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoursePriorityRepository extends JpaRepository<CoursePriority, CoursePriorityKey> {
}
