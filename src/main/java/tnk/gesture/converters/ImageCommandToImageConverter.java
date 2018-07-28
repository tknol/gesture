package tnk.gesture.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;

@Component
public class ImageCommandToImageConverter implements Converter<ImageCommand, Image> {

    @Synchronized
    @Nullable
    @Override
    public Image convert(ImageCommand source) {
        final Image image = new Image();
        image.setName(source.getName());

        return image;
    }
}
