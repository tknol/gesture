package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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

        User user = all.iterator().next();
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping("viewimages")
    public String getImages(Model model, final RedirectAttributes redirectAttributes) throws Exception {
        Iterable<User> all = userService.getUsers();

        if(!all.iterator().hasNext())
            throw new Exception("User not found"); // todo tnk fix this

        User user = all.iterator().next();
        model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:images";
    }
}
