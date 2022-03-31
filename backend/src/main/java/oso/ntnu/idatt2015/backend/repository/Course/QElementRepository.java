package oso.ntnu.idatt2015.backend.repository.Course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.Course.QElement;

@Repository
public interface QElementRepository extends JpaRepository<QElement, Long> {
}
