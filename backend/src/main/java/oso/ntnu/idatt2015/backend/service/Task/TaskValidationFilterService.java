package oso.ntnu.idatt2015.backend.service.Task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.Task.TaskValidationFilter;
import oso.ntnu.idatt2015.backend.repository.Task.TaskValidationFilterRepository;

import java.util.List;

@Service
public class TaskValidationFilterService {
    private final TaskValidationFilterRepository taskValidationFilterRepository;

    @Autowired
    public TaskValidationFilterService(TaskValidationFilterRepository taskValidationFilterRepository){
        this.taskValidationFilterRepository = taskValidationFilterRepository;
    }

    public List<TaskValidationFilter> getAllFilters(){
        return taskValidationFilterRepository.findAll();
    }
}
