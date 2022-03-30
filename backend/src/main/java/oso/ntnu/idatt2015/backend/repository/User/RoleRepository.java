package oso.ntnu.idatt2015.backend.repository.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import oso.ntnu.idatt2015.backend.model.User.QRole;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<QRole, Long> {
    Optional<QRole> findByRole(String role);
}
