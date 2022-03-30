package oso.ntnu.idatt2015.backend.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "users")
@Getter @Setter @NoArgsConstructor
public class QUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;
    //Add more later

    @ManyToOne
    private UserLevel userLevel;

    /*
    @OneToMany(mappedBy = "user")
    Set<UserRoleCourse> userRoleCourses;

     */

    public QUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    /*
    public QUser(String username, String password, UserLevel userLevel){
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
    }
     */
}
