package oso.ntnu.idatt2015.backend.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourseKey;

import java.util.List;

@Repository
public interface UserRoleCourseRepository extends JpaRepository<UserRoleCourse, UserRoleCourseKey> {
    public List<UserRoleCourse> findCourseByUserAndRole(Long username, Long roleId);
    public List<UserRoleCourse> findByUser(QUser user);
}
