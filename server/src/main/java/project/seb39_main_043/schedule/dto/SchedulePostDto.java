package project.seb39_main_043.schedule.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class SchedulePostDto {

    private String title;

    // 참석자
    private String attendees;

    //https://shanepark.tistory.com/263
    private LocalDateTime startEventAt;
    private LocalDateTime endEventAt;

    private String location;
    private String contents;
}

