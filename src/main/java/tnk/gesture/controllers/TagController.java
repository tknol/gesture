package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import tnk.gesture.model.User;

@Controller
public class TagController {

    @GetMapping({"viewtags", "tag/viewtags"})
    public String viewTags(@SessionAttribute("user") User user,
                           Model model){
        model.addAttribute("user", user);
        return "viewtags";
    }
}
