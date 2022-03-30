package oso.ntnu.idatt2015.backend.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.User.QUser;

import java.util.Optional;

@Repository
public interface UserRepository  extends JpaRepository<QUser, Long> {
    Optional<QUser> findByUsername(String username);
    }
