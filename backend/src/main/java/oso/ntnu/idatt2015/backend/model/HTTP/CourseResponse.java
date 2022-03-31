package oso.ntnu.idatt2015.backend.model.HTTP;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;

import java.util.List;

@Getter @Setter @NoArgsConstructor
public class CourseResponse {
    private List<QCourse> teacher;
    private List<QCourse> assistant;
    private List<QCourse> student;

    public CourseResponse(List<QCourse> teacher, List<QCourse> assistant, List<QCourse> student) {
        this.teacher = teacher;
        this.assistant = assistant;
        this.student = student;
    }
}
