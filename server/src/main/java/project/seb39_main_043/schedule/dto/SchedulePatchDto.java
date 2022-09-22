package project.seb39_main_043.schedule.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchedulePatchDto {

    private Long scheduleId;
    private String title;
    private String scheduleAt;
    private String attendees;
    private String location;
    private String contents;

}
