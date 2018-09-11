package tnk.gesture.converters;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tnk.gesture.commands.ScheduleCommand;
import tnk.gesture.model.Schedule;


public class ScheduleToScheduleCommandConverterTest {

    private ScheduleToScheduleCommandConverter converter;

    @Mock private ScheduleItemToScheduleItemCommandConverter mockScheduleItemToScheduleItemCommandConverter;

    @Before
    public void setUo(){
        MockitoAnnotations.initMocks(this);
        converter = new ScheduleToScheduleCommandConverter(mockScheduleItemToScheduleItemCommandConverter);
    }

    @Test
    public void testConvert(){
        Schedule source = new Schedule();
        source.setName("Schedule 1");
        source.setDescription("Description 1");

        ScheduleCommand convert = converter.convert(source);

        Assert.assertEquals("Schedule 1", convert.getName());
        Assert.assertEquals("Description 1", convert.getDescription());
    }

}