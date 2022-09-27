package project.seb39_main_043.calendar.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.seb39_main_043.calendar.dto.CalendarPatchDto;
import project.seb39_main_043.calendar.dto.CalendarPostDto;
import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.calendar.mapper.CalendarMapper;
import project.seb39_main_043.calendar.service.CalendarService;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/calendars")
public class CalendarController {

    private final CalendarService calendarService;
    private final CalendarMapper mapper;

    public CalendarController(CalendarService calendarService, CalendarMapper mapper) {
        this.calendarService = calendarService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postCalendar(@Valid @RequestBody CalendarPostDto calendarPostDto) {

        log.info("postCalendar");
        Calendar response = calendarService.createCalendar(mapper.calendarPostDtoToCalendar(calendarPostDto));

        return new ResponseEntity<>(
                mapper.calendarToCalendarResponseDto(response), HttpStatus.CREATED);
    }

    @PatchMapping("{calendar-id}")
    public ResponseEntity updateCalendar(@PathVariable("calendar-id") long calendarId,
                                        @RequestBody CalendarPatchDto calendarPatchDto) {
        log.info("updateCalendar");
        calendarPatchDto.setCalendarId(calendarId);
        Calendar response = calendarService.updateCalendar(mapper.calendarPatchDtoToCalendar(calendarPatchDto));

        return new ResponseEntity<>(
                mapper.calendarToCalendarResponseDto(response), HttpStatus.ACCEPTED);
    }

    @GetMapping("{calendar-id}")
    public ResponseEntity getCalendar(@PathVariable("calendar-id") long calendarId) {

        log.info("getCalendar");
        Calendar response = calendarService.findCalendar(calendarId);

        return new ResponseEntity<>(
                mapper.calendarToCalendarResponseDto(response), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCalendars() {

        log.info("getCalendars");
        List<Calendar> response = calendarService.findCalendars();
        return new ResponseEntity<>(mapper.calendarToCalendarResponseDtos(response), HttpStatus.OK);
    }

    @DeleteMapping("{calendar-id}")
    public ResponseEntity deleteCalendar(@PathVariable("calendar-id") long calendarId) {

        log.info("deleteCalendar");
        calendarService.deleteCalendar(calendarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
