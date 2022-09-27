package project.seb39_main_043.calendar.dto;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
public class CalendarPostDto {

    @NotNull
    private String title;
    private String calendarImg;

    @NotNull
    private List<CalendarMemberDto> calendarMembers;
}
