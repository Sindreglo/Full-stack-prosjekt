package oso.ntnu.idatt2015.backend.model.User;


import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
public class QRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;
    @Column(unique = true)
    String role;

    /*
    @OneToMany(mappedBy = "role")
    Set<UserRoleCourse> userRoleCourses;
     */

    public QRole() {
    }

    public QRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
