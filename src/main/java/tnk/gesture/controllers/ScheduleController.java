package tnk.gesture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import tnk.gesture.model.User;

@Controller
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
