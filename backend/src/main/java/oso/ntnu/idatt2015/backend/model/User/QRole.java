package oso.ntnu.idatt2015.backend.model.User;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter @Setter @NoArgsConstructor
public class QRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(unique = true)
    private String role;

    /*
    @OneToMany(mappedBy = "role")
    Set<UserRoleCourse> userRoleCourses;
     */

    public QRole(String role) {
        this.role = role;
    }


}
