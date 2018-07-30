package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tnk.gesture.model.User;
import tnk.gesture.services.UserService;

@Controller
@SessionAttributes("user") //todo i haven't decided the best way to do this yet.
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"", "/", "/index"})
    public String getUser(Model model) throws Exception {
        User user = getUser();
        model.addAttribute("user", user);
        return "index";
    }

    @ModelAttribute("user")
    public User getUser() throws Exception {
        Iterable<User> all = userService.getUsers();

        if(!all.iterator().hasNext())
            throw new Exception("User not found"); // todo tnk fix this

        return all.iterator().next();
    }

    @GetMapping("viewimages")
    @Transactional
    public String getImages(Model model, final RedirectAttributes redirectAttributes) throws Exception {
        User user = getUser();
        model.addAttribute("user", user);
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:images";
    }

    @GetMapping("about")
    public String getAbout(@SessionAttribute("user") User user,
                           Model model){
        model.addAttribute("user", user);
        return "about";
    }
}
