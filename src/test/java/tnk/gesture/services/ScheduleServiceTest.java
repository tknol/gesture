package tnk.gesture.services;

import com.google.common.collect.Iterables;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tnk.gesture.model.Schedule;
import tnk.gesture.repositories.ScheduleRepository;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ScheduleServiceTest {

    private ScheduleService scheduleService;
    @Mock private ScheduleRepository mockScheduleRepository;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.scheduleService = new ScheduleServiceImpl(mockScheduleRepository);
    }

    @Test
    public void findAll() {

        Set<Schedule>results = new HashSet<>();
        results.add(new Schedule());

        when(mockScheduleRepository.findAll()).thenReturn(results);

        Iterable<Schedule> all = scheduleService.findAll();

        assertEquals(1, Iterables.size(all));
        verify(mockScheduleRepository, times(1)).findAll();

    }
}