package oso.ntnu.idatt2015.backend.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourseKey;

@Repository
public interface UserRoleCourseRepository extends JpaRepository<UserRoleCourse, UserRoleCourseKey> {
}
