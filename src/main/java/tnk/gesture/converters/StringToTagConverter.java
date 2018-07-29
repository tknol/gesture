package tnk.gesture.converters;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Tag;

@Component
public class StringToTagConverter implements Converter<String, Tag> {

    @Override
    public Tag convert(String source) {

        Tag tag = new Tag();
        tag.setName(source);

        return tag;
    }
}
