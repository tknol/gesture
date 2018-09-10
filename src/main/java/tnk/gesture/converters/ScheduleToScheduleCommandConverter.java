package tnk.gesture.converters;

import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import tnk.gesture.commands.ScheduleCommand;
import tnk.gesture.model.Schedule;
import tnk.gesture.model.ScheduleItem;
import tnk.gesture.model.Tag;

@Component
public class ScheduleToScheduleCommandConverter implements Converter<Schedule, ScheduleCommand> {

    private ScheduleItemToScheduleItemCommandConverter scheduleItemCommandConverter;
    //private TagT

    public ScheduleToScheduleCommandConverter(ScheduleItemToScheduleItemCommandConverter scheduleItemCommandConverter) {
        this.scheduleItemCommandConverter = scheduleItemCommandConverter;
    }


    @Synchronized
    @Nullable
    @Override
    public ScheduleCommand convert(Schedule source) {
        ScheduleCommand command = new ScheduleCommand();
        command.setId(source.getId());
        command.setDescription(source.getDescription());
        command.setName(source.getName());
        for(ScheduleItem item : source.getScheduleItems()){
            command.getScheduleItems().add(scheduleItemCommandConverter.convert(item));
        }
        return command;
    }
}
