package rest_js.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rest_js.model.Role;
import rest_js.repositories.RoleRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void saveRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleById(long id) {
        Optional<Role> foundRole = roleRepository.findById(id);
        return foundRole.orElse(null);
    }
}
