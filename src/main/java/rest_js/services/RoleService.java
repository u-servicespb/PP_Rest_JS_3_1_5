package rest_js.services;

import rest_js.model.Role;

import java.util.List;

public interface RoleService {

    List<Role> getAllRoles();

    void saveRole(Role role);

    Role getRoleById(long id);

}
