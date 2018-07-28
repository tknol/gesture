package tnk.gesture.controllers;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.constants.Mappings;
import tnk.gesture.model.User;
import tnk.gesture.services.ImageService;
import tnk.gesture.services.UserService;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

@Controller
public class ImageController {

    private ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/" + Mappings.IMAGES)
    public String getImages(@ModelAttribute("user") final User user,
                            final BindingResult mapping1BindingResult,
                            final Model model){

        model.addAttribute("user", user);

        return Mappings.IMAGES;
    }

    @GetMapping("{userId}/image/new")
    public String createImage(@PathVariable String userId, Model model) {

        ImageCommand imageCommand = new ImageCommand();
        imageCommand.setUserId(userId);

        model.addAttribute("image", imageCommand);

        return "imageform";
    }

    @PostMapping("{userId}/image")
    public String createNewImage(@ModelAttribute ImageCommand imageCommand, @RequestParam("imagefile")MultipartFile file){

        imageService.saveImage(imageCommand, file);

        return "redirect:/index";
    }

    @GetMapping("{id}/image")
    public void renderImageFromDB(@PathVariable String id, HttpServletResponse response) throws Exception {
        ImageCommand recipeCommand = imageService.findById(id);

        if (recipeCommand.getImageData() != null) {
            byte[] byteArray = new byte[recipeCommand.getImageData().length];
            int i = 0;

            for (Byte wrappedByte : recipeCommand.getImageData()){
                byteArray[i++] = wrappedByte; //auto unboxing
            }

            response.setContentType("image/jpeg");
            InputStream is = new ByteArrayInputStream(byteArray);
            IOUtils.copy(is, response.getOutputStream());
        }
    }
}
