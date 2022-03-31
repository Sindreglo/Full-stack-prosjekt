package oso.ntnu.idatt2015.backend.controller.Course;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.Course.QElement;
import oso.ntnu.idatt2015.backend.service.Course.QElementService;

import java.util.List;

@RestController
@RequestMapping("/api/qelement")
public class QElementController {
    private final QElementService qElementService;

    @Autowired
    public QElementController(QElementService qElementService){
        this.qElementService = qElementService;
    }

    @GetMapping
    public List<QElement> getCourses(){
        return qElementService.getAllQElements();
    }
}
