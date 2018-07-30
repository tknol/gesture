package tnk.gesture.converters;

import org.junit.Before;
import org.junit.Test;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;
import tnk.gesture.model.User;

import static org.junit.Assert.*;

public class ImageToImageCommandConverterTest {

    private ImageToImageCommandConverter imageToImageCommandConverter;

    @Before
    public void setUp(){
        imageToImageCommandConverter = new ImageToImageCommandConverter();
    }

    @Test
    public void convert() {

        Image source = new Image();
        source.setId(1L);
        Tag tag1 = new Tag();
        tag1.setName("tag1");
        source.getTags().add(tag1);
        Tag tag2 = new Tag();
        tag2.setName("tag2");
        source.getTags().add(tag2);
        source.setName("testimage");
        User user = new User();
        user.setId(1L);
        source.setUser(user);

        ImageCommand result = imageToImageCommandConverter.convert(source);

        assertEquals(1L, result.getUserId().longValue());
//        assertEquals("tag1, tag2", result.getTags()); //todo these need to be sorted
        assertEquals("testimage", result.getName());
    }
}