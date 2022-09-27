package project.seb39_main_043.calendar.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CalendarMemberResponseDto {

    private long memberId;
    private String email;
    private String name;
}
