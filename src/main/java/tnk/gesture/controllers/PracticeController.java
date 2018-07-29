package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PracticeController {

    @GetMapping("practice")
    public String getPractice(Model model){

        return "practice";
    }
}
