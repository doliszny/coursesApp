package pl.project.courses.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.project.courses.model.User;
import pl.project.courses.service.UserService;

import javax.validation.Valid;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("/formularz")
    public String form(Model model) {
        model.addAttribute("user", new User());
        return "formularz";
    }

    @PostMapping("/formularz")
    public String courseSuccess(@Valid @ModelAttribute User user,
                                BindingResult bindingResult,
                                Model model) {

        model.addAttribute("user", user);

        if (bindingResult.hasErrors()) {
            return "formularz";
        }

        userService.save(user);

        return "kurs-sukces";
    }
}


