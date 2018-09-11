package tnk.gesture.converters;

import org.junit.Before;
import org.junit.Test;
import tnk.gesture.commands.ScheduleItemCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.ScheduleItem;
import tnk.gesture.model.User;

import static org.junit.Assert.*;

public class ScheduleItemToScheduleItemCommandConverterTest {

    private ScheduleItemToScheduleItemCommandConverter converter;

    @Before
    public void setUp() {
        converter = new ScheduleItemToScheduleItemCommandConverter(new ImageToImageCommandConverter());
    }

    @Test
    public void convert() {

        ScheduleItem item = new ScheduleItem();
        Image image = new Image();
        image.setName("My Image");
        item.getImages().add(image);
        item.setImageCount(20);
        item.setDuration(5000);
        item.setId(1L);
        image.setUser(new User());

        ScheduleItemCommand result = converter.convert(item);

        assertEquals(1L, result.getId().longValue());
        assertEquals(5000, result.getDuration());
        assertEquals(20, result.getImageCount());
        assertEquals("My Image", result.getImages().iterator().next().getName());

    }
}