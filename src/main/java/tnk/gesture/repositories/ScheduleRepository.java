package tnk.gesture.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import tnk.gesture.model.Schedule;
import tnk.gesture.model.User;

@Component
public interface ScheduleRepository extends CrudRepository<Schedule, Long> {
}
