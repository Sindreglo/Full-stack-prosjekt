package oso.ntnu.idatt2015.backend.model;

import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "course")
public class QCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    String courseName;

    /*
    @OneToMany(mappedBy = "course")
    Set<UserRoleCourse> userRoleCourses;

     */

    public QCourse(String courseName) {
        this.courseName = courseName;
    }

    public QCourse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
