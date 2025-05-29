package dev.skyherobrine.project.backend.repositories.postgresql;

import dev.skyherobrine.project.backend.models.postgresql.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends PagingAndSortingRepository<Department,Long>, CrudRepository<Department,Long> {

}
