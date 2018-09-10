package tnk.gesture.services;

import org.springframework.web.multipart.MultipartFile;
import tnk.gesture.commands.ImageCommand;
import tnk.gesture.model.Image;
import tnk.gesture.model.Schedule;

public interface ScheduleService {

    Iterable<Schedule> findAll();

}
