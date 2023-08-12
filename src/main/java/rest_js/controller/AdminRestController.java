package rest_js.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import rest_js.model.Role;
import rest_js.model.User;
import rest_js.services.RoleService;
import rest_js.services.UserService;

import java.util.List;

@RestController
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/api/admin")
public class AdminRestController {

    private final RoleService roleService;
    private final UserService userService;

    @Autowired
    public AdminRestController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return users != null && !users.isEmpty()
                ? new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
        User user = userService.findUserById(id);
        return user != null
                ? new ResponseEntity<>(user, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/roles")
    public ResponseEntity<List<Role>> getAllRoles() {
        List<Role> roleList = roleService.getAllRoles();
        return ResponseEntity.ok(roleList);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> saveNewUser(@RequestBody User user) {
        userService.saveUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody User user) {
        userService.updateUser(user);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
