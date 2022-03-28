package oso.ntnu.idatt2015.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.QCourse;

@Repository
public interface CourseRepository extends JpaRepository<QCourse, Long> {
}
