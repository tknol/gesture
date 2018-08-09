package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import tnk.gesture.model.User;

@RestController
@RequestMapping("/api")
public class PracticeController {

    @GetMapping({"practice"})
    public String getPractice(@SessionAttribute("user") User user,
                              Model model){
        model.addAttribute("user", user);
        return "practice";
    }
}
