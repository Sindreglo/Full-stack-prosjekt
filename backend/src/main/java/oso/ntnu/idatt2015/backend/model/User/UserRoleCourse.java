package oso.ntnu.idatt2015.backend.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;

import javax.persistence.*;

@Entity
@Getter @Setter @NoArgsConstructor
public class UserRoleCourse {
    @EmbeddedId
    UserRoleCourseKey id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    QUser user;

    @ManyToOne
    @MapsId("roleId")
    @JoinColumn(name = "role_id")
    QRole role;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    QCourse course;


    public UserRoleCourse(QUser user, QRole role, QCourse course) {
        this.id = new UserRoleCourseKey(user, role, course);
        this.user = user;
        this.role = role;
        this.course = course;
    }
}
