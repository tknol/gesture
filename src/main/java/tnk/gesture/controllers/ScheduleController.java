package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ScheduleController {

    @GetMapping("viewschedules")
    public String viewSchedules(Model model){

        return "viewschedules";
    }
}
