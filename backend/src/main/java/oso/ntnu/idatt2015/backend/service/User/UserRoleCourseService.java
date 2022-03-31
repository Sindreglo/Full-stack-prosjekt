package oso.ntnu.idatt2015.backend.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;
import oso.ntnu.idatt2015.backend.model.HTTP.CourseResponse;
import oso.ntnu.idatt2015.backend.model.User.QRole;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.repository.Course.CourseRepository;
import oso.ntnu.idatt2015.backend.repository.User.UserRepository;
import oso.ntnu.idatt2015.backend.repository.User.UserRoleCourseRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRoleCourseService {
    private final UserRoleCourseRepository userRoleCourseRepository;
    private final CourseRepository courseRepository;
    private final UserRepository userRepository;

    @Autowired
    public UserRoleCourseService(UserRoleCourseRepository userRoleCourseRepository, CourseRepository courseRepository, UserRepository userRepository){
        this.userRoleCourseRepository = userRoleCourseRepository;
        this.courseRepository = courseRepository;
        this.userRepository = userRepository;
    }

    public String connectUserCourseService(QUser user, QCourse course, QRole role){
        return (user.getUsername());
    }

    public List<UserRoleCourse> getURC(){
        return userRoleCourseRepository.findAll();
    }

    public CourseResponse findByUsername(String username) {
        QUser user = userRepository.findByUsername(username).get();
        List<UserRoleCourse> userRoleCourseList = userRoleCourseRepository.findByUser(user);
        List<QCourse> studList = extractCourse(userRoleCourseList, "student");
        List<QCourse> profList = extractCourse(userRoleCourseList, "professor");
        List<QCourse> assList = extractCourse(userRoleCourseList, "assistant");

        return new CourseResponse(profList, assList, studList);
    }

    public List<QCourse> extractCourse(List<UserRoleCourse> userRoleCourses, String role){
        List<QCourse> returnList = new ArrayList<>();
        for (UserRoleCourse urc:userRoleCourses) {
            if (urc.getRole().getRole().equalsIgnoreCase(role))
            returnList.add(urc.getCourse());
        }
        return returnList;
    }

}
