package oso.ntnu.idatt2015.backend.model.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Task.Task;
import oso.ntnu.idatt2015.backend.model.Task.TaskValidationFilter;
import oso.ntnu.idatt2015.backend.model.User.QUser;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "course")
@Getter @Setter @NoArgsConstructor
public class QCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String courseName;

    @OneToMany
    private List<Task> Tasks;
    @OneToMany
    private List<QUser> students;
    @OneToMany
    private List<QUser> assistants;
    @OneToMany
    private List<QUser> teachers;

    @ManyToOne
    private TaskValidationFilter taskValidationFilter;

    @OneToMany
    private List<QElement> queue;

    public QCourse(String courseName) {
        this.courseName = courseName;
    }

    public void addTask(Task task){
        this.Tasks.add(task);
    }
}
