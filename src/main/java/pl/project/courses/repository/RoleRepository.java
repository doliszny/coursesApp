package pl.project.courses.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.project.courses.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Role getByRole(String role);
}
