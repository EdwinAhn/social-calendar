package project.seb39_main_043.schedule.comment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.member.entity.Member;
import project.seb39_main_043.schedule.entity.Schedule;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ScheduleComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleCommentId;

    @Column(length = 100)
    private String contents;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();

    public ScheduleComment(Long scheduleCommentId, String contents) {
        this.scheduleCommentId = scheduleCommentId;
        this.contents = contents;
    }

    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private Schedule schedule;

    public void setSchedule(Schedule schedule) {

        if (this.schedule != null) {
            this.schedule.getScheduleComments().remove(this);
        }

        this.schedule = schedule;
        if (!schedule.getScheduleComments().contains(this)) {
            schedule.getScheduleComments().add(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {

        this.member = member;
        if (!member.getScheduleComments().contains(this)) {
            member.getScheduleComments().add(this);
        }
    }
}