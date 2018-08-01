package tnk.gesture.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.constants.Mappings;
import tnk.gesture.model.Image;
import tnk.gesture.model.User;
import tnk.gesture.services.ImageService;
import tnk.gesture.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class ImageControllerTest {

    private ImageController imageController;
    @Mock
    private ImageService imageService;
    @Mock
    private Model model;
    @Mock
    private BindingResult bindingResult;
    private MockMvc mockMvc;
    @Mock MultipartFile file;
    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        imageController = new ImageController(imageService);
        mockMvc = MockMvcBuilders.standaloneSetup(imageController).build();
    }
    @Test
    public void getImages() {

        User user = new User();

        String images = imageController.getImages(user, bindingResult, model);


        assertEquals(Mappings.IMAGES, images);
        verify(model, times(1)).addAttribute("user", user);
    }


    @Test
    public void createImage() throws Exception {
        //given
        ImageCommand imageCommand = new ImageCommand();
        imageCommand.setId(1L);
        User user = new User();
        user.setId(1L);

        //when
        String result = imageController.createImage(user.getId().toString(), model);

        //then
        assertEquals("imageform", result);
        verify(model, times(1)).addAttribute(anyString(), any(ImageCommand.class));

    }

//
//    @Test
//    public void createImage() throws Exception {
//        //given
//        ImageCommand imageCommand = new ImageCommand();
//        imageCommand.setId("abc");
//        User user = new User();
//        user.setId("abc");
//
//        //when
//        when(imageService.saveImage(imageCommand, file)).thenReturn(imageCommand);
//        String result = imageController.createImage(user.getId(), model);
//
//        //then
//        assertEquals("redirect:/index", result);
//        verify(userService, times(1)).getUsers();
//        verify(model, times(1)).addAttribute("user", users.iterator().next());
//
//    }
}