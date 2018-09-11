package tnk.gesture.converters;

import org.junit.Before;
import org.junit.Test;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;

import static org.junit.Assert.*;

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