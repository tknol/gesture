package tnk.gesture.controllers.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import tnk.gesture.commands.ScheduleCommand;
import tnk.gesture.converters.ScheduleToScheduleCommandConverter;
import tnk.gesture.model.Schedule;
import tnk.gesture.services.ScheduleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
@Api(tags = {"schedules"})
@Slf4j
public class ScheduleApiController {


    private ScheduleService scheduleService;
    private final ScheduleToScheduleCommandConverter scheduleToScheduleCommandConverter;

    public ScheduleApiController(ScheduleService scheduleService, ScheduleToScheduleCommandConverter scheduleToScheduleCommandConverter) {
        this.scheduleService = scheduleService;
        this.scheduleToScheduleCommandConverter = scheduleToScheduleCommandConverter;
    }

    @RequestMapping(value = "schedules",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all schedules.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    @Transactional
    @ResponseBody public List<ScheduleCommand> getSchedules(
                                               HttpServletRequest request, HttpServletResponse response){

        log.info("Finding Schedules...");
        Iterable<Schedule> all = scheduleService.findAll();
        log.info("Returning schedules");
        List<ScheduleCommand> schedules = new ArrayList();
        for(Schedule schedule : all){
            schedules.add(scheduleToScheduleCommandConverter.convert(schedule));
        }
        return schedules;
    }

}
