package project.seb39_main_043.schedule.comment.dto;

import lombok.Getter;

@Getter
public class ScheduleCommentPostDto {

    private Long scheduleId;
    private Long memberId;
    private String contents;
}
