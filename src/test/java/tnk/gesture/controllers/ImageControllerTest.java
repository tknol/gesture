package tnk.gesture.controllers;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.constants.Mappings;
import tnk.gesture.model.Image;
import tnk.gesture.services.ImageService;
import tnk.gesture.services.UserService;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
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
    ImageService imageService;
    @Mock
    UserService userService;
    @Mock
    Model model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        imageController = new ImageController(imageService, userService);
    }
    @Test
    public void getImages() {

        Iterable<Image> imageData = new ArrayList<>();
        ((ArrayList<Image>) imageData).add(new Image());


        when(imageService.findAll()).thenReturn(imageData);

        String images = imageController.getImages(model);

        assertEquals(Mappings.IMAGES, images);
        verify(imageService).findAll();
        verify(model, times(1)).addAttribute("images", imageData);
    }

    @Test
    public void createImage() {
        //given
        ImageCommand imageCommand = new ImageCommand();
        imageCommand.setId("abc");

        //when
        //when(recipeService.findRecipeCommandById(anyLong())).thenReturn(imageCommand);

        //then
//        mockMvc.perform(get("/recipe/1/ingredient/new"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("recipe/ingredient/ingredientform"))
//                .andExpect(model().attributeExists("ingredient"))
//                .andExpect(model().attributeExists("uomList"));
//
//        verify(recipeService, times(1)).findRecipeCommandById(anyLong());

    }
}