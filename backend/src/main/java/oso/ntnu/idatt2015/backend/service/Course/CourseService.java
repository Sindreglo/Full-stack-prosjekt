package oso.ntnu.idatt2015.backend.service.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;
import oso.ntnu.idatt2015.backend.repository.Course.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {
    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public List<QCourse> getAllCourses() {
        return courseRepository.findAll();
    }

    public QCourse getById(long id) {
        if (courseRepository.findById(id).isPresent()){
            return courseRepository.findById(id).get();
        }
    }
}
