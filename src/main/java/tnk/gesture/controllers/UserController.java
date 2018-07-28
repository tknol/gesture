package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tnk.gesture.model.User;
import tnk.gesture.repositories.UserRepository;

@Controller
public class UserController {

    private UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @RequestMapping({"", "/", "/index"})
    public String getUser(Model model){
        Iterable<User> all = userRepository.findAll();

        model.addAttribute("user", all.iterator().next());

        return "index";
    }
}
