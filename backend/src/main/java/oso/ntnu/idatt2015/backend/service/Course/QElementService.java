package oso.ntnu.idatt2015.backend.service.Course;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import oso.ntnu.idatt2015.backend.model.Course.QElement;
import oso.ntnu.idatt2015.backend.repository.Course.QElementRepository;

import java.util.List;

@Service
public class QElementService {
    private final QElementRepository qElementRepository;

    @Autowired
    public QElementService(QElementRepository qElementRepository){
        this.qElementRepository = qElementRepository;
    }

    public List<QElement> getAllQElements(){
        return qElementRepository.findAll();
    }
}
