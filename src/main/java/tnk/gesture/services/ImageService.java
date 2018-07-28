package tnk.gesture.services;

import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;

public interface ImageService {

    Iterable<Image> findAll();
    void saveImageFile(String id, MultipartFile file);

    ImageCommand saveImage(ImageCommand imageCommand, MultipartFile file);

    ImageCommand findById(String id) throws Exception;
}
