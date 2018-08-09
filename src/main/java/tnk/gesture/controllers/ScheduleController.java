package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tnk.gesture.model.User;

@RestController
@RequestMapping("/api")
public class ScheduleController {

    @GetMapping({"viewschedules", "schedule/viewschedules"})
    public String viewSchedules(@SessionAttribute("user") User user,
                                Model model){
        model.addAttribute("user", user);
        return "viewschedules";
    }

    @GetMapping({"newschedule"})
    public String newSchedule(@SessionAttribute("user") User user,
                              Model model){
        model.addAttribute("user", user);
        return "newschedule";
    }
}
