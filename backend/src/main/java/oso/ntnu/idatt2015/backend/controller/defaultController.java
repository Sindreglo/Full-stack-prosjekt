package oso.ntnu.idatt2015.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.repository.UserRepository;


@RestController
public class defaultController {
    @RequestMapping("/")
    public String home() {
        return "Hello Docker World";
    }


    @Autowired
    UserRepository userRepository;

}
