package tnk.gesture.converters;

import lombok.Synchronized;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;

@Component
public class ImageToImageCommandConverter implements Converter<Image, ImageCommand> {

    @Synchronized
    @Nullable
    @Override
    public ImageCommand convert(Image source) {
        final ImageCommand image = new ImageCommand();
        image.setName(source.getName());
//        image.setUserId(source.getUser().getId()); //todo not setting user on the image, this is giving mongodb problems (cyclical dependency?)
        image.setId(source.getId());
        image.setTags(StringUtils.join(source.getTags(), ","));
        image.setImageData(source.getImageData());

        return image;
    }
}
