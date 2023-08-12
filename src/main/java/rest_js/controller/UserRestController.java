package rest_js.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import rest_js.model.User;
import rest_js.services.UserService;

import java.security.Principal;

@RestController("/api/user")
@PreAuthorize("hasRole('USER')")
public class UserRestController {

    private final UserService userService;

    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<User> getUser(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByEmail(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
