package tnk.gesture.converters;

import lombok.Synchronized;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.Tag;

import java.util.Iterator;

@Component
public class ImageToImageCommandConverter implements Converter<Image, ImageCommand> {

    @Synchronized
    @Nullable
    @Override
    public ImageCommand convert(Image source) {
        final ImageCommand image = new ImageCommand();
        image.setName(source.getName());
        image.setUserId(source.getUser().getId());
        image.setId(source.getId());
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = source.getTags().iterator();
        while(iterator.hasNext()){
            stringBuilder.append(((Tag)iterator.next()).getName());
            if(iterator.hasNext())
                stringBuilder.append(", ");
        }
        image.setTags(stringBuilder.toString());
        image.setImageData(source.getImageData());

        return image;
    }
}
