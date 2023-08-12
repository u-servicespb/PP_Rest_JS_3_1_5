package rest_js.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import rest_js.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String username);
}