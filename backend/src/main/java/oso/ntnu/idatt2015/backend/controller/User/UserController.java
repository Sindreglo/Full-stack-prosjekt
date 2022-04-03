package oso.ntnu.idatt2015.backend.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.HTTP.UserResponse;
import oso.ntnu.idatt2015.backend.service.Security.JwtUtil;
import oso.ntnu.idatt2015.backend.service.User.UserService;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@RequestMapping("/api/user")
public class UserController {
    private final UserService userService;
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<?> getUser(HttpServletRequest request){
        String username = jwtUtil.extractUsername(request.getHeader("Authorization").substring(7));
        return ResponseEntity.ok(new UserResponse(userService.getUserByUsername(username)));
    }
}
