package oso.ntnu.idatt2015.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.QCourse;
import oso.ntnu.idatt2015.backend.model.User.QRole;
import oso.ntnu.idatt2015.backend.model.User.QUser;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.repository.UserRoleCourseRepository;

import java.util.List;

@Service
public class UserRoleCourseService {
    private final UserRoleCourseRepository userRoleCourseRepository;

    @Autowired
    public UserRoleCourseService(UserRoleCourseRepository userRoleCourseRepository){
        this.userRoleCourseRepository = userRoleCourseRepository;
    }

    public String connectUserCourseService(QUser user, QCourse course, QRole role){
        return (user.getUsername());
    }

    public List<UserRoleCourse> getURC(){
        return userRoleCourseRepository.findAll();
    }
}
