package tnk.gesture.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tnk.gesture.model.Schedule;
import tnk.gesture.repositories.ScheduleRepository;

@Slf4j
@Service
public class ScheduleServiceImpl implements ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @Override
    public Iterable<Schedule> findAll() {
        return scheduleRepository.findAll();
    }
}
