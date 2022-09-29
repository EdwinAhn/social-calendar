package project.seb39_main_043.schedule.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.seb39_main_043.schedule.comment.entity.ScheduleComment;

import java.util.List;

public interface ScheduleCommentRepository extends JpaRepository<ScheduleComment, Long> {

    List<ScheduleComment> findScheduleCommentBySchedule_ScheduleId(long scheduleId);
}
