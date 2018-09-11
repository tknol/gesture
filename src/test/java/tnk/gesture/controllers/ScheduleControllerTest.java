package tnk.gesture.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import tnk.gesture.constants.Mappings;
import tnk.gesture.model.User;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class ScheduleControllerTest {

    private ScheduleController scheduleController;
    @Mock private Model model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        scheduleController = new ScheduleController();
    }

    @Test
    public void viewSchedules() {
        User user = new User();

        String result = scheduleController.viewSchedules(user, model);

        assertEquals(Mappings.VIEW_SCHEDULES, result);
        verify(model, times(1)).addAttribute("user", user);
    }

    @Test
    public void newSchedule() {
        User user = new User();

        String result = scheduleController.newSchedule(user, model);

        assertEquals(Mappings.NEW_SCHEDULE, result);
        verify(model, times(1)).addAttribute("user", user);
    }
}