package pl.project.courses.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(   //@RequestParam

                                   String username, Model model) {
        System.out.println("Podane imie: " + username);

        model.addAttribute("imie", username);

        return "home";
    }

}
