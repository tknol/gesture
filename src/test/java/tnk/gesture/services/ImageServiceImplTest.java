package tnk.gesture.services;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.model.Image;
import tnk.gesture.repositories.ImageRepository;

import java.io.IOException;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ImageServiceImplTest {

    @Mock private ImageRepository imageRepository;
    private ImageService imageService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        imageService = new ImageServiceImpl(imageRepository);
    }

    @Test
    public void saveImageFile() throws IOException {

        //given
        String id = "abc";
        MultipartFile multipartFile = new MockMultipartFile("imagefile", "testing.txt", "text/plain",
                "whatever".getBytes());

        Image image = new Image();
        image.setId(id);
        Optional<Image> imageOptional = Optional.of(image);

        when(imageRepository.findById(anyString())).thenReturn(imageOptional);

        ArgumentCaptor<Image> argumentCaptor = ArgumentCaptor.forClass(Image.class);

        //when
        imageService.saveImageFile(id, multipartFile);

        //then
        verify(imageRepository, times(1)).save(argumentCaptor.capture());
        Image savedImage = argumentCaptor.getValue();
        assertEquals(multipartFile.getBytes().length, savedImage.getImageData().length);
    }
}