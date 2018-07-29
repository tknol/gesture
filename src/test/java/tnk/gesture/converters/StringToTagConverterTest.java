package tnk.gesture.converters;

import org.junit.Test;
import tnk.gesture.model.Tag;

import static org.junit.Assert.*;

public class StringToTagConverterTest {

    private StringToTagConverter stringToTagConverter = new StringToTagConverter();

    @Test
    public void convert() {

        Tag result = stringToTagConverter.convert("abc");

        assertEquals("abc", result.getName());

    }
}