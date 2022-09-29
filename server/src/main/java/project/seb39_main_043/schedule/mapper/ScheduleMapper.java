package project.seb39_main_043.schedule.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.member.entity.Member;
import project.seb39_main_043.schedule.dto.SchedulePatchDto;
import project.seb39_main_043.schedule.dto.SchedulePostDto;
import project.seb39_main_043.schedule.dto.ScheduleResponseDto;
import project.seb39_main_043.schedule.entity.Schedule;

import java.util.ArrayList;
import java.util.List;

@Mapper
@Component
public class ScheduleMapper {

    public Schedule schedulePostDtoToSchedule(SchedulePostDto schedulePostDto) {
        Schedule schedule = new Schedule();
        Member member = new Member();
        Calendar calendar = new Calendar();

        member.setMemberId(schedulePostDto.getMemberId());
        calendar.setCalendarId(schedulePostDto.getCalendarId());
        schedule.setTitle(schedulePostDto.getTitle());
        schedule.setScheduleAt(schedulePostDto.getScheduleAt());
        schedule.setAttendees(schedulePostDto.getAttendees());
        schedule.setLocation(schedulePostDto.getLocation());
        schedule.setContents(schedulePostDto.getContents());

        schedule.setMember(member);
        schedule.setCalendar(calendar);
        return schedule;
    }

    public Schedule schedulePatchDtoToSchedule(SchedulePatchDto schedulePatchDto) {
        if (schedulePatchDto == null) {
            return null;
        } else {
            Schedule schedule = new Schedule();
            schedule.setScheduleId(schedulePatchDto.getScheduleId());
            schedule.setTitle(schedulePatchDto.getTitle());
            schedule.setScheduleAt(schedulePatchDto.getScheduleAt());
            schedule.setAttendees(schedulePatchDto.getAttendees());
            schedule.setLocation(schedulePatchDto.getLocation());
            schedule.setContents(schedulePatchDto.getContents());
            return schedule;
        }
    }
    public ScheduleResponseDto scheduleToScheduleResponseDto(Schedule schedule) {

        if (schedule == null) {
            return null;
        } else {
            Long memberId = schedule.getMember().getMemberId();
            Long calendarId = schedule.getCalendar().getCalendarId();
            Long scheduleId = schedule.getScheduleId();
            String title = schedule.getTitle();
            String scheduleAt = schedule.getScheduleAt();
            String attendees = schedule.getAttendees();
            String location = schedule.getLocation();
            String contents = schedule.getContents();

            ScheduleResponseDto scheduleResponseDto
                    = new ScheduleResponseDto(memberId, calendarId, scheduleId, title, scheduleAt, attendees, location, contents);
            return scheduleResponseDto;
        }
    }

    public List<ScheduleResponseDto> scheduleToScheduleResponseDtos(List<Schedule> schedules) {

        if (schedules == null) {
            return null;
        } else {
            List<ScheduleResponseDto> list = new ArrayList<>(schedules.size());
            for (Schedule schedule : schedules) {
                list.add(scheduleToScheduleResponseDto(schedule));
            }
            return list;
        }
    }
}
