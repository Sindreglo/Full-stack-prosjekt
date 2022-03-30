package oso.ntnu.idatt2015.backend.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.User.UserLevel;

@Repository
public interface UserLevelRepository extends JpaRepository<UserLevel, Long> {

}
