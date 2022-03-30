package oso.ntnu.idatt2015.backend.service.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.User.UserLevel;
import oso.ntnu.idatt2015.backend.repository.User.UserLevelRepository;

import java.util.List;

@Service
public class UserLevelService {
    private final UserLevelRepository userLevelRepository;

    @Autowired
    public UserLevelService(UserLevelRepository userLevelRepository){
        this.userLevelRepository = userLevelRepository;
    }

    public List<UserLevel> getAllUserLevels() {
        return userLevelRepository.findAll();
    }
}