package oso.ntnu.idatt2015.backend.model.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Task.Task;
import oso.ntnu.idatt2015.backend.model.Task.TaskValidationFilter;
import oso.ntnu.idatt2015.backend.model.User.QUser;

import javax.persistence.*;
import java.util.ArrayList;
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
    /*
    @OneToMany
    private List<QUser> students;
    @OneToMany
    private List<QUser> assistants;
    @OneToMany
    private List<QUser> teachers;

     */

    @ManyToOne
    private TaskValidationFilter taskValidationFilter;

    @OneToMany
    private List<QElement> queue;

    public QCourse(String courseName) {
        this.courseName = courseName;
        initArrays();
    }

    public void addTask(Task task){
        initArrays();
        this.Tasks.add(task);
    }

    public void initArrays(){
        if (this.Tasks == null){
            this.Tasks = new ArrayList<>();
        }
        /*
        if (this.students == null){
            this.students = new ArrayList<>();
        }
        if (this.assistants == null){
            this.assistants = new ArrayList<>();
        }
        if (this.teachers == null){
            this.teachers = new ArrayList<>();
        }

         */
    }
}
