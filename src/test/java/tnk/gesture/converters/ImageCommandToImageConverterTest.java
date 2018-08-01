package tnk.gesture.converters;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

public class ImageCommandToImageConverterTest {

    private ImageCommandToImageConverter imageCommandToImageConverter;

    @Before
    public void setUp(){
        imageCommandToImageConverter = new ImageCommandToImageConverter(new StringToTagConverter());
    }

    @Test
    public void convert() {

        ImageCommand source = new ImageCommand();
        source.setName("imagename");
        source.setTags("tag1, tag2");

        Image result = imageCommandToImageConverter.convert(source);

        assertEquals("imagename", result.getName());
        assertEquals(2, result.getTags().size());
    }
}