package project.seb39_main_043.schedule.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.seb39_main_043.schedule.dto.SchedulePostDto;
import project.seb39_main_043.schedule.entity.Schedule;
import project.seb39_main_043.schedule.service.ScheduleService;

@Slf4j
@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity postSchedule(@RequestBody SchedulePostDto schedulePostDto) {

        log.info("postSchedule");
        Schedule schedule = new Schedule();
        schedule.setScheduleId(1L);
        schedule.setTitle(schedulePostDto.getTitle());
        schedule.setLocation(schedulePostDto.getLocation());
        schedule.setContents(schedulePostDto.getContents());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/{schedule-id}")
    public ResponseEntity getSchedule(@PathVariable("schedule-id") long scheduleId) {

        log.info("getSchedule");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getSchedules() {

        log.info("getSchedules");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PatchMapping("/{schedule-id}")
    public ResponseEntity updateSchedule(@PathVariable("schedule-id") long scheduleId) {

        log.info("updateSchedule");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("{schedule-id}")
    public ResponseEntity deleteSchedule(@PathVariable("schedule-id") long scheduleId) {

        log.info("deleteSchedule");
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
