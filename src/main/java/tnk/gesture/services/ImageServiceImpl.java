package tnk.gesture.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.model.Image;
import tnk.gesture.repositories.ImageRepository;

import java.io.IOException;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    public ImageServiceImpl( ImageRepository recipeService) {

        this.imageRepository = recipeService;
    }

    @Override
    @Transactional
    public void saveImageFile(String imageId, MultipartFile file) {

        try {
            Image image = imageRepository.findById(imageId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            image.setImageData(byteObjects);

            imageRepository.save(image);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }
    }
}
