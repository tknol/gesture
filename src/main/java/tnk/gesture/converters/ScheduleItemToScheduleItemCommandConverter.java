package tnk.gesture.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ScheduleItemCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.ScheduleItem;

@Component
public class ScheduleItemToScheduleItemCommandConverter implements Converter<ScheduleItem, ScheduleItemCommand> {

    private ImageToImageCommandConverter imageToImageCommandConverter;

    public ScheduleItemToScheduleItemCommandConverter(ImageToImageCommandConverter imageToImageCommandConverter) {
        this.imageToImageCommandConverter = imageToImageCommandConverter;
    }

    @Synchronized
    @Nullable
    @Override
    public ScheduleItemCommand convert(ScheduleItem source) {

        ScheduleItemCommand command = new ScheduleItemCommand();
        command.setDuration(source.getDuration());
        command.setId(source.getId());
        command.setImageCount(source.getImageCount());
        for(Image image : source.getImages()) {
            command.getImages().add(imageToImageCommandConverter.convert(image));
        }
        return command;
    }
}
