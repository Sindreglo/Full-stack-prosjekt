package oso.ntnu.idatt2015.backend.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.User.UserRoleCourse;
import oso.ntnu.idatt2015.backend.service.User.UserRoleCourseService;

import java.util.List;

@RestController
@RequestMapping("/api/userrolecourse")
public class UserRoleCourseController {
    private final UserRoleCourseService userRoleCourseService;

    @Autowired
    public UserRoleCourseController(UserRoleCourseService userRoleCourseService){
        this.userRoleCourseService = userRoleCourseService;
    }

    @GetMapping
    public List<UserRoleCourse> getUserRoleCourses(){
        return userRoleCourseService.getURC();
    }
}
