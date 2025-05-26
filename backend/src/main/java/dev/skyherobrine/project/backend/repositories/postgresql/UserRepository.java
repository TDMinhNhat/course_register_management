package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.models.postgresql.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
