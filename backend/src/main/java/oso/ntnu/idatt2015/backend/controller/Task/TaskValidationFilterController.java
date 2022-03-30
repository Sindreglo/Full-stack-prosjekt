package oso.ntnu.idatt2015.backend.controller.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import oso.ntnu.idatt2015.backend.model.Task.TaskValidationFilter;
import oso.ntnu.idatt2015.backend.service.Task.TaskValidationFilterService;

import java.util.List;

@RestController
@RequestMapping("/api/filter")
public class TaskValidationFilterController {
    private final TaskValidationFilterService taskValidationFilterService;

    @Autowired
    public TaskValidationFilterController(TaskValidationFilterService taskValidationFilterService){
        this.taskValidationFilterService = taskValidationFilterService;
    }

    @GetMapping
    public List<TaskValidationFilter> getCourses(){
        return taskValidationFilterService.getAllFilters();
    }
}
