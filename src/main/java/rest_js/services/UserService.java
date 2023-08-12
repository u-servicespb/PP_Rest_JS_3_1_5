package rest_js.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import rest_js.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {

    User saveUser(User user);

    User findUserById(long id);

    List<User> getAllUsers();

    User updateUser(User updateUser);

    void deleteUser(long id);

    User findByEmail(String email);
}