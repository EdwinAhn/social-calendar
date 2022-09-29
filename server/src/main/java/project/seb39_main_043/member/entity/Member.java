package project.seb39_main_043.member.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.calendar.entity.CalendarMember;
import project.seb39_main_043.common.BaseEntity;
import project.seb39_main_043.diary.entity.Diary;
import project.seb39_main_043.schedule.comment.entity.ScheduleComment;
import project.seb39_main_043.schedule.entity.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100)
    private String email;

    @Column(length = 50)
    private String name;

    @Column(length = 100)
    private String password;

    @Column(length = 100)
    private String memberImg;

    @Column(length = 50)
    private String statusMessage;

    @OneToMany(mappedBy = "member")
    private List<Diary> diaries = new ArrayList<>();

    public void addDiary(Diary diary) {

        this.diaries.add(diary);
        if (diary.getMember() != this) {
            diary.setMember(this);
        }
    }

    @OneToMany(mappedBy = "member")
    private List<Schedule> schedules = new ArrayList<>();

    public void addSchedule(Schedule schedule) {

        this.schedules.add(schedule);
        if (schedule.getMember() != this) {
            schedule.setMember(this);
        }
    }

    @OneToMany(mappedBy = "member")
    private List<CalendarMember> calendarMembers = new ArrayList<>();

    public void addCalendarMember(CalendarMember calendarMember) {
        this.calendarMembers.add(calendarMember);
        if (calendarMember.getMember() != this) {
            calendarMember.addMember(this);
        }
    }

    @OneToMany(mappedBy = "member")
    private List<ScheduleComment> scheduleComments = new ArrayList<>();
}

