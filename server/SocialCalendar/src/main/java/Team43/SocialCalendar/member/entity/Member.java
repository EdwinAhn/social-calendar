package Team43.SocialCalendar.member.entity;

import Team43.SocialCalendar.calendar.entity.CalendarAttendee;
import Team43.SocialCalendar.calendar.mapper.EmailToMemberId;
import Team43.SocialCalendar.diary.entity.Diary;
import Team43.SocialCalendar.schedule.entity.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberId;

    @Column(length = 500)
    private String memberImg;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 50)
    private String statusMessage;

    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column
    private LocalDateTime modifiedAt = LocalDateTime.now();

    @OneToMany(mappedBy = "memberId")
    private List<CalendarAttendee> calendarAttendees = new ArrayList<>();

    public void addCalendarAttendee(CalendarAttendee calendarAttendee) {
        this.calendarAttendees.add(calendarAttendee);
        if (calendarAttendee.getMemberId() != this) {
            calendarAttendee.addMember(this);
        }
    }

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

}
