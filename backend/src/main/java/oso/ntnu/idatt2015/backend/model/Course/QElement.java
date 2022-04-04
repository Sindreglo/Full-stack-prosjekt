package oso.ntnu.idatt2015.backend.model.Course;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Task.Task;
import oso.ntnu.idatt2015.backend.model.User.QUser;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "queue_element")
@Getter @Setter @NoArgsConstructor
public class QElement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    private Task task;

    @OneToMany
    List<QUser> students;

    public void addStudent(QUser student){
        initArrays();
        this.students.add(student);
    }

    public void addStudent(List<QUser> students){
        initArrays();
        this.students.addAll(students);
    }

    public void initArrays(){
        if (this.students == null){
            this.students = new ArrayList<>();
        }
    }

    public void approve(){
        for (QUser student:students) {
            student.approveTask(task);
        }
    }

    public void fail(){
        for (QUser student:students) {
            student.failTask(task);
        }
    }
}
