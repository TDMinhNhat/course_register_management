package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.models.postgresql.UserRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends CrudRepository<UserRole,Long> {
}
