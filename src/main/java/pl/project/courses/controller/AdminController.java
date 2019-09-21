package pl.project.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.project.courses.service.UserService;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/lista-kursantow")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userService.findAll());

        return "lista-kursantow";
    }

    @PostMapping("/lista-kursantow")
    public String searchUser(@RequestParam String searchText,
                             @RequestParam String searchParameter,
                             Model model) {
        model.addAttribute("users", userService.searchUser(searchText, searchParameter));
        return "lista-kursantow";
    }
}
