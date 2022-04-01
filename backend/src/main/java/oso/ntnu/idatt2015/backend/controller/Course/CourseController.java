package oso.ntnu.idatt2015.backend.controller.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.Course.QCourse;
import oso.ntnu.idatt2015.backend.model.HTTP.CourseResponse;
import oso.ntnu.idatt2015.backend.service.Course.CourseService;
import oso.ntnu.idatt2015.backend.service.Security.JwtUtil;
import oso.ntnu.idatt2015.backend.service.User.UserRoleCourseService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/course")
public class CourseController {
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

    //@CrossOrigin
    @GetMapping
    public ResponseEntity<?> getCoursesByUser(HttpServletRequest request){
        String username = jwtUtil.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(userRoleCourseService.findByUsername(username));
        //return userRoleCourseService.findByUsername(username).header('Access-Control-Allow-Origin','*');;
    }
}
