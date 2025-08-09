package kz.ruzgaliyev.internetmagazin.service;

import kz.ruzgaliyev.internetmagazin.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface RoleService {
    Role createRole(Role role);
    Role getRoleById(Long id);
    Role updateRole(Long id,Role role);
    List<Role> getAllRoles();
    void deleteRole(Long id);
}
