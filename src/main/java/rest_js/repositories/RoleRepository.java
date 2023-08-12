package rest_js.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_js.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}