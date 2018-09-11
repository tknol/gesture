package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Schedule;

@Component
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
