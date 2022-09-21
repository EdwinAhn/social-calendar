package project.seb39_main_043.member.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.diary.entity.Diary;
import project.seb39_main_043.membercalendar.MemberCalendar;
import project.seb39_main_043.schedule.entity.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 100)
    private String memberImg;

    @Column(length = 100, nullable = false, unique = true)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

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
    private List<MemberCalendar> memberCalendars = new ArrayList<>();
}

