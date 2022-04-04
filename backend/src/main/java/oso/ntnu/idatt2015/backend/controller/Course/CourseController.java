package oso.ntnu.idatt2015.backend.controller.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;
import oso.ntnu.idatt2015.backend.model.HTTP.CourseResponse;
import oso.ntnu.idatt2015.backend.model.HTTP.IdRequest;
import oso.ntnu.idatt2015.backend.service.Course.CourseService;
import oso.ntnu.idatt2015.backend.service.Security.JwtUtil;
import oso.ntnu.idatt2015.backend.service.User.UserRoleCourseService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private final CourseService courseService;

    @Autowired
    private final JwtUtil jwtUtil;

    @Autowired
    private final UserRoleCourseService userRoleCourseService;

    @Autowired
    public CourseController(CourseService courseService, JwtUtil jwtUtil, UserRoleCourseService userRoleCourseService){
        this.courseService = courseService;
        this.jwtUtil = jwtUtil;
        this.userRoleCourseService = userRoleCourseService;
    }

    @GetMapping
    public CourseResponse getCoursesByUser(HttpServletRequest request){
        String username = jwtUtil.extractUsername(request.getHeader("Authorization").substring(7));
        return userRoleCourseService.findByUsername(username);
    }

    @GetMapping(path = "/id")
    public QCourse getCourseById(@RequestBody IdRequest idRequest) {
        return courseService.getById(idRequest.getId());
    }
}
