package oso.ntnu.idatt2015.backend.model.User;

import oso.ntnu.idatt2015.backend.model.Course.QCourse;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class UserRoleCourseKey implements Serializable {
    @Column(name = "user_id")
    Long userId;

    @Column(name = "role_id")
    Long roleId;

    @Column(name = "course_id")
    Long courseId;

    public UserRoleCourseKey(Long userId, Long roleId, Long courseId) {
        this.userId = userId;
        this.roleId = roleId;
        this.courseId = courseId;
    }

    public UserRoleCourseKey(QUser user, QRole role, QCourse course) {
        this.userId = user.getId();
        this.roleId = role.getId();
        this.courseId = course.getId();
    }

    public UserRoleCourseKey() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getFullId(){
        return ""+this.userId+this.courseId+this.roleId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleCourseKey)) return false;
        UserRoleCourseKey that = (UserRoleCourseKey) o;
        return getUserId().equals(that.getUserId()) && getRoleId().equals(that.getRoleId()) && getCourseId().equals(that.getCourseId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUserId(), getRoleId(), getCourseId());
    }
}
