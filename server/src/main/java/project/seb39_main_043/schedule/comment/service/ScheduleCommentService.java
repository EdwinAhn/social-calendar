package project.seb39_main_043.schedule.comment.service;

import org.springframework.stereotype.Service;
import project.seb39_main_043.schedule.comment.entity.ScheduleComment;
import project.seb39_main_043.schedule.comment.repository.ScheduleCommentRepository;

import java.util.List;

@Service
public class ScheduleCommentService {

    private ScheduleCommentRepository scheduleCommentRepository;

    public ScheduleCommentService(ScheduleCommentRepository scheduleCommentRepository) {
        this.scheduleCommentRepository = scheduleCommentRepository;
    }

    public ScheduleComment createScheduleComment(ScheduleComment scheduleComment) {
        return scheduleCommentRepository.save(scheduleComment);
    }

    public List<ScheduleComment> findScheduleCommentsByScheduleId(Long scheduleId) {
        return scheduleCommentRepository.findScheduleCommentBySchedule_ScheduleId(scheduleId);
    }
}
