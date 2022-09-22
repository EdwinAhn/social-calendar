package project.seb39_main_043.schedule.mapper;

import org.mapstruct.Mapper;
import project.seb39_main_043.schedule.dto.SchedulePatchDto;
import project.seb39_main_043.schedule.dto.SchedulePostDto;
import project.seb39_main_043.schedule.dto.ScheduleResponseDto;
import project.seb39_main_043.schedule.entity.Schedule;

@Mapper(componentModel = "spring")
public interface ScheduleMapper {

    Schedule schedulePostDtoToSchedule(SchedulePostDto schedulePostDto);
    Schedule schedulePatchDtoToSchedule(SchedulePatchDto schedulePatchDto);
    ScheduleResponseDto scheduleToScheduleResponseDto(Schedule schedule);

}
