package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tnk.gesture.model.User;
import tnk.gesture.services.UserService;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getUser(Model model) throws Exception {
        Iterable<User> all = userService.getUsers();

        if(!all.iterator().hasNext())
            throw new Exception("User not found"); // todo tnk fix this

            model.addAttribute("user", all.iterator().next());

        return "index";
    }
}
