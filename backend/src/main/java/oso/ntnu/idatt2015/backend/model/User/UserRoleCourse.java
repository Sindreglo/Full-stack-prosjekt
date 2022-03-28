package oso.ntnu.idatt2015.backend.model.User;

import oso.ntnu.idatt2015.backend.model.QCourse;

import javax.persistence.*;

@Entity
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


    public UserRoleCourse() {
    }

    public UserRoleCourse(QUser user, QRole role, QCourse course) {
        this.user = user;
        this.role = role;
        this.course = course;
    }

    public UserRoleCourseKey getId() {
        return id;
    }

    public void setId(UserRoleCourseKey id) {
        this.id = id;
    }

    public QUser getUser() {
        return user;
    }

    public void setUser(QUser user) {
        this.user = user;
    }

    public QRole getRole() {
        return role;
    }

    public void setRole(QRole role) {
        this.role = role;
    }

    public QCourse getCourse() {
        return course;
    }

    public void setCourse(QCourse course) {
        this.course = course;
    }
}
