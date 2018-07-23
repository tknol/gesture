package tnk.gesture.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import tnk.gesture.constants.Mappings;
import tnk.gesture.repositories.ImageRepository;

@Controller
public class ImageController {

    @Autowired private ImageRepository imageRepository;

    @RequestMapping("/" + Mappings.IMAGES)
    public String getImages(Model model){

        model.addAttribute("images", imageRepository.findAll());

        return Mappings.IMAGES;
    }
}
