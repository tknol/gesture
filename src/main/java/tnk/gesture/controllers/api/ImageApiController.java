package tnk.gesture.controllers.api;

import com.google.common.collect.Lists;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tnk.gesture.constants.Mappings;
import tnk.gesture.model.Image;
import tnk.gesture.model.User;
import tnk.gesture.services.ImageService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping(value = "/api/images")
@Api(tags = {"images"})
public class ImageApiController {

    private ImageService imageService;

    public ImageApiController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all images.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @ResponseBody public List<Image> getImages(@ModelAttribute("user") final User user,
                                               HttpServletRequest request, HttpServletResponse response){

        Iterable<Image> all = imageService.findAll();
        return Lists.newArrayList(all);
    }
}



//    @ApiParam(value = "The page number (zero-based)", required = true)
//    @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
//    @ApiParam(value = "Tha page size", required = true)
//    @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
//    HttpServletRequest request, HttpServletResponse response