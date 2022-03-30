package oso.ntnu.idatt2015.backend.controller.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.User.UserLevel;
import oso.ntnu.idatt2015.backend.service.User.UserLevelService;

import java.util.List;

@RestController
@RequestMapping("/api/userLevel")
public class UserLevelController {
    private final UserLevelService userLevelService;

    @Autowired
    public UserLevelController(UserLevelService userLevelService){
        this.userLevelService = userLevelService;
    }

    @GetMapping
    public List<UserLevel> getUsers(){
        return userLevelService.getAllUserLevels();
    }
}
