package project.seb39_main_043.schedule.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.common.BaseEntity;
import project.seb39_main_043.diary.entity.Diary;
import project.seb39_main_043.member.entity.Member;
import project.seb39_main_043.schedule.comment.entity.ScheduleComment;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 100, nullable = false)
    private String attendees;

    @Column(length = 100, nullable = false)
    private String scheduleAt;

    @Column(length = 100)
    private String location;

    @Column(length = 100)
    private String contents;

    @OneToMany(mappedBy = "schedule")
    private List<ScheduleComment> scheduleComments = new ArrayList<>();

    public void addScheduleComment(ScheduleComment scheduleComment) {

        this.scheduleComments.add(scheduleComment);
        if (scheduleComment.getSchedule() != this) {
            scheduleComment.setSchedule(this);
        }
    }

    @OneToOne
    @JoinColumn(name = "diary_id")
    private Diary diary;

    public void setDiary(Diary diary) {
        this.diary = diary;
        diary.setSchedule(this);
    }

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {

        this.member = member;
        if (!member.getSchedules().contains(this)) {
            member.getSchedules().add(this);
        }
    }

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public void setCalendar(Calendar calendar) {

        this.calendar = calendar;
        if (!calendar.getSchedules().contains(this)) {
            calendar.getSchedules().add(this);
        }
    }
}
