package tnk.gesture.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.converters.ImageCommandToImageConverter;
import tnk.gesture.converters.ImageToImageCommandConverter;
import tnk.gesture.model.Image;
import tnk.gesture.model.User;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.UserRepository;

import java.io.IOException;
import java.util.Optional;

@Slf4j
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final UserRepository userRepository;
    private final ImageCommandToImageConverter imageCommandToImageConverter;
    private final ImageToImageCommandConverter imageToImageCommandConverter;

    public ImageServiceImpl( ImageRepository recipeService, ImageCommandToImageConverter imageCommandToImageConverter,
                             UserRepository userRepository, ImageToImageCommandConverter imageToImageCommandConverter) {

        this.imageRepository = recipeService;
        this.imageCommandToImageConverter = imageCommandToImageConverter;
        this.userRepository = userRepository;
        this.imageToImageCommandConverter = imageToImageCommandConverter;
    }

    @Override
    public Iterable<Image> findAll() {
        return imageRepository.findAll();
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

    @Override
    @Transactional
    public ImageCommand saveImage(ImageCommand imageCommand, MultipartFile file) {

        try {
            Image image = imageCommandToImageConverter.convert(imageCommand);
            User user = userRepository.findById(imageCommand.getUserId()).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            image.setImageData(byteObjects);

            user.getImages().add(image);
            userRepository.save(user);
            //image.setUser(user);
            imageRepository.save(image);
        } catch (IOException e) {
            //todo handle better
            log.error("Error occurred", e);

            e.printStackTrace();
        }

        return null;
    }

    @Override
    public ImageCommand findById(String id) throws Exception {
        Optional<Image> image = imageRepository.findById(id);

        if(!image.isPresent())
            throw new Exception("Image not found"); //todo need better handling

        ImageCommand imageCommand = imageToImageCommandConverter.convert(image.get());

        return imageCommand;
    }
}
