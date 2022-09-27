package project.seb39_main_043.calendar.service;

import org.springframework.stereotype.Service;
import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.calendar.repository.CalendarRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CalendarService {

    private final CalendarRepository calendarRepository;

    public CalendarService(CalendarRepository calendarRepository) {
        this.calendarRepository = calendarRepository;
    }

    public Calendar createCalendar(Calendar calendar) {
        return calendarRepository.save(calendar);
    }

    public Calendar updateCalendar(Calendar calendar) {
        Calendar findCalendar = findVerifiedCalendar(calendar.getCalendarId());

        Optional.ofNullable(calendar.getTitle())
                .ifPresent(title -> findCalendar.setTitle(title));
        Optional.ofNullable(calendar.getCalendarImg())
                .ifPresent(calendarImg -> findCalendar.setCalendarImg(calendarImg));

        return calendarRepository.save(findCalendar);
    }

    public Calendar findCalendar(long calendarId) {
        return findVerifiedCalendar(calendarId);
    }

    public List<Calendar> findCalendars() {
        return calendarRepository.findAll();
    }

    public void deleteCalendar(long calendarId) {
        Calendar findCalendar = findVerifiedCalendar(calendarId);
        calendarRepository.delete(findCalendar);
    }

    private Calendar findVerifiedCalendar(Long calendarId) {

        Optional<Calendar> optionalCalendar = calendarRepository.findById(calendarId);
        Calendar findCalendar = optionalCalendar.orElseThrow(() ->
                new IllegalArgumentException("유효하지 않은 달력입니다."));    // 이거 뭘로 잡아야될지 모르겠음..

        findCalendar.getCalendarMembers();
        return findCalendar;
    }
}
