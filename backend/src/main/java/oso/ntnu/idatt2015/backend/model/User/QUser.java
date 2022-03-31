package oso.ntnu.idatt2015.backend.model.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Task.Task;

import javax.persistence.*;
import java.util.List;


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

    @OneToMany
    private List<Task> approvedTasks;

    @OneToMany
    private List<Task> failedTasks;

    /*
    @OneToMany(mappedBy = "user")
    Set<UserRoleCourse> userRoleCourses;

     */

    public QUser(String username, String password){
        this.username = username;
        this.password = password;
    }


    public void failTask(Task task){
        this.failedTasks.add(task);
        this.approvedTasks.remove(task);
    }

    public void approveTask(Task task){
        this.approvedTasks.add(task);
        this.failedTasks.remove(task);
    }

    /*
    public QUser(String username, String password, UserLevel userLevel){
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
    }
     */
}
