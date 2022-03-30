package oso.ntnu.idatt2015.backend.repository.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.Task.TaskValidationFilter;

@Repository
public interface TaskValidationFilterRepository extends JpaRepository<TaskValidationFilter, Long> {
}
