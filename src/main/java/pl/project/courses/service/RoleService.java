package pl.project.courses.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.project.courses.model.Role;
import pl.project.courses.repository.RoleRepository;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getByRole(String role) {
        return roleRepository.getByRole(role);
    }
}
