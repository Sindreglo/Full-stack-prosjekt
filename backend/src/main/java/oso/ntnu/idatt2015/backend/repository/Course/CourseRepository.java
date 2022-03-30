package oso.ntnu.idatt2015.backend.repository.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;

@Repository
public interface CourseRepository extends JpaRepository<QCourse, Long> {
}
