package project.seb39_main_043.calendar.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CalendarResponseDto {

    private Long calendarId;
    private String title;
    private String calendarImg;

    private List<CalendarMemberResponseDto> calendarMembers;

    private long scheduleId;
}