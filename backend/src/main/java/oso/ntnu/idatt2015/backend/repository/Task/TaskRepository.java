package oso.ntnu.idatt2015.backend.repository.Task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.Task.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
