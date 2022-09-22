package project.seb39_main_043.schedule.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import project.seb39_main_043.schedule.dto.SchedulePatchDto;
import project.seb39_main_043.schedule.dto.SchedulePostDto;
import project.seb39_main_043.schedule.dto.ScheduleResponseDto;
import project.seb39_main_043.schedule.entity.Schedule;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-09-22T21:30:14+0900",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.14.1 (Azul Systems, Inc.)"
)
@Component
public class ScheduleMapperImpl implements ScheduleMapper {

    @Override
    public Schedule schedulePostDtoToSchedule(SchedulePostDto schedulePostDto) {
        if ( schedulePostDto == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setTitle( schedulePostDto.getTitle() );
        schedule.setAttendees( schedulePostDto.getAttendees() );
        schedule.setScheduleAt( schedulePostDto.getScheduleAt() );
        schedule.setLocation( schedulePostDto.getLocation() );
        schedule.setContents( schedulePostDto.getContents() );

        return schedule;
    }

    @Override
    public Schedule schedulePatchDtoToSchedule(SchedulePatchDto schedulePatchDto) {
        if ( schedulePatchDto == null ) {
            return null;
        }

        Schedule schedule = new Schedule();

        schedule.setScheduleId( schedulePatchDto.getScheduleId() );
        schedule.setTitle( schedulePatchDto.getTitle() );
        schedule.setAttendees( schedulePatchDto.getAttendees() );
        schedule.setScheduleAt( schedulePatchDto.getScheduleAt() );
        schedule.setLocation( schedulePatchDto.getLocation() );
        schedule.setContents( schedulePatchDto.getContents() );

        return schedule;
    }

    @Override
    public ScheduleResponseDto scheduleToScheduleResponseDto(Schedule schedule) {
        if ( schedule == null ) {
            return null;
        }

        Long scheduleId = null;
        String title = null;
        String scheduleAt = null;
        String attendees = null;
        String location = null;
        String contents = null;

        scheduleId = schedule.getScheduleId();
        title = schedule.getTitle();
        scheduleAt = schedule.getScheduleAt();
        attendees = schedule.getAttendees();
        location = schedule.getLocation();
        contents = schedule.getContents();

        ScheduleResponseDto scheduleResponseDto = new ScheduleResponseDto( scheduleId, title, scheduleAt, attendees, location, contents );

        return scheduleResponseDto;
    }
}
