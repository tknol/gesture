package tnk.gesture.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.Arrays;
import java.util.List;

@Component
public class ImageCommandToImageConverter implements Converter<ImageCommand, Image> {

    private StringToTagConverter stringToTagConverter;

    public ImageCommandToImageConverter(StringToTagConverter stringToTagConverter) {
        this.stringToTagConverter = stringToTagConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public Image convert(ImageCommand source) {
        final Image image = new Image();
        image.setName(source.getName());
        image.setUser(source.getUser());
        if(!source.getTags().isEmpty()) {
            List<String> tags = Arrays.asList(source.getTags().split(","));
            for (String tagName : tags) {
                Tag tag = stringToTagConverter.convert(tagName);
                tag.getImages().add(image);
                tag.setUser(source.getUser());
                image.getTags().add(tag);
            }
        }
        return image;
    }
}
