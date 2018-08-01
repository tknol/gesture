package tnk.gesture.services;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.converters.ImageCommandToImageConverter;
import tnk.gesture.converters.ImageToImageCommandConverter;
import tnk.gesture.model.Image;
import tnk.gesture.repositories.ImageRepository;
import tnk.gesture.repositories.UserRepository;

import java.io.IOException;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageServiceImplTest {

    @Mock private ImageRepository imageRepository;
    private ImageService imageService;
    @Mock private ImageCommandToImageConverter imageCommandToImageConverter;
    @Mock private UserRepository userRepository;
    @Mock private ImageToImageCommandConverter imageToImageCommandConverter;
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        imageService = new ImageServiceImpl(imageRepository, imageCommandToImageConverter, userRepository, imageToImageCommandConverter);
    }

    @Test
    public void saveImageFile() throws IOException {

        //given
        Long id = 1L;
        MultipartFile multipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain",
                "whatever".getBytes());

        Image image = new Image();
        image.setId(id);
        Optional<Image> imageOptional = Optional.of(image);

        when(imageRepository.findById(anyLong())).thenReturn(imageOptional);

        ArgumentCaptor<Image> argumentCaptor = ArgumentCaptor.forClass(Image.class);

        //when
        imageService.saveImageFile(id, multipartFile);

        //then
        verify(imageRepository, times(1)).save(argumentCaptor.capture());
        Image savedImage = argumentCaptor.getValue();
        assertEquals(multipartFile.getBytes().length, savedImage.getImageData().length);
    }

    @Test
    public void testFindAll(){

        Set<Image> imageData = new HashSet<>();
        imageData.add(new Image());
        when(imageRepository.findAll()).thenReturn(imageData);

        Iterable<Image> all = imageService.findAll();

        assertEquals(1, Iterables.size(all));
        verify(imageRepository, times(1)).findAll();

    }
}