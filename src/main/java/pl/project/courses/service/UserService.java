package pl.project.courses.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.project.courses.model.Role;
import pl.project.courses.model.User;
import pl.project.courses.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    public void save(User user) {

        Role role = roleService.getByRole("user");
        user.setRole(role);

        //kodowanie hasła użytkownika przed zapisem do bazy danych
        PasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public List<User> searchUser(String searchText, String searchParameter) {
        switch (searchParameter) {
            case "firstName":
                return userRepository.getByFirstName(searchText);
            case "lastName":
                return userRepository.getByLastName(searchText);
            case "mail":
                return userRepository.getByMail(searchText);
            case "phone":
                return userRepository.getByPhone(searchText);
            case "course":
                return userRepository.getByCourse(searchText);
            case "mode":
                return userRepository.getByMode(searchText);
            default:
                return userRepository.findAll();
        }
    }
}
