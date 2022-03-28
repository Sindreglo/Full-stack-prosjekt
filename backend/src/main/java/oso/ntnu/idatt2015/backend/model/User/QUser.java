package oso.ntnu.idatt2015.backend.model.User;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;


@Entity
@Table(name = "users")
public class QUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String username;
    private String password;
    //Add more later

    public QUser(){}
    public QUser(String username, String password){
        this.username = username;
        this.password = password;
    }

    /*
    @OneToMany(mappedBy = "user")
    Set<UserRoleCourse> userRoleCourses;


     */
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getUserDetails(){
        return new User(this.username, this.password, new ArrayList<>());
    }
}
