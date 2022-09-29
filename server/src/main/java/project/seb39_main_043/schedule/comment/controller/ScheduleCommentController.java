package project.seb39_main_043.schedule.comment.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.seb39_main_043.schedule.comment.dto.ScheduleCommentPostDto;
import project.seb39_main_043.schedule.comment.entity.ScheduleComment;
import project.seb39_main_043.schedule.comment.mapper.ScheduleCommentMapper;
import project.seb39_main_043.schedule.comment.service.ScheduleCommentService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/schedulecomments")
public class ScheduleCommentController {

    private final ScheduleCommentService scheduleCommentService;
    private final ScheduleCommentMapper mapper;

    public ScheduleCommentController(ScheduleCommentService scheduleCommentService, ScheduleCommentMapper mapper) {
        this.scheduleCommentService = scheduleCommentService;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity postScheduleComment(@RequestBody ScheduleCommentPostDto scheduleCommentPostDto) {

        log.info("postScheduleComment");
        ScheduleComment response = scheduleCommentService.createScheduleComment(mapper.scheduleCommentPostDtoToScheduleComment(scheduleCommentPostDto));

        return new ResponseEntity<>(
                mapper.scheduleCommentToScheduleCommentResponseDto(response), HttpStatus.CREATED);

    }

    @GetMapping("{schedule-id}")
    public ResponseEntity getScheduleCommentsByScheduleId(@PathVariable("schedule-id") Long scheduleId) {

        log.info("getScheduleComments");
        List<ScheduleComment> response = scheduleCommentService.findScheduleCommentsByScheduleId(scheduleId);

        return new ResponseEntity<>(mapper.scheduleCommentsToScheduleCommentResponseDto(response), HttpStatus.OK);
    }
}
