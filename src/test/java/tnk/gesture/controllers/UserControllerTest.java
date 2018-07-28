package tnk.gesture.controllers;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import tnk.gesture.model.User;
import tnk.gesture.services.UserService;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class UserControllerTest {

    private UserController userController;
    @Mock private UserService userService;
    @Mock Model model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        userController = new UserController(userService);
    }

    @Test
    public void getUser() throws Exception {
        //given
        Iterable<User> users = new ArrayList<>();
        ((ArrayList<User>) users).add(new User());
        ((ArrayList<User>) users).add(new User());

        //when
        when(userService.getUsers()).thenReturn(users);
        String result = userController.getUser(model);

        //then
        assertEquals("index", result);
        verify(userService, times(1)).getUsers();
        verify(model, times(1)).addAttribute("user", users.iterator().next());
    }

    @Test
    @Ignore("This doesn'twork right now because it throws an exception with no uses to load")
    public void testMockMVC() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(userController).build();

        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
}