package project.seb39_main_043.calendar.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.membercalendar.MemberCalendar;
import project.seb39_main_043.schedule.entity.Schedule;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Calendar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarId;

    @Column(length = 20)
    private String title;

    @Column(length = 100)
    private String calendarImg;

    @OneToMany(mappedBy = "calendar")
    private List<MemberCalendar> memberCalendars = new ArrayList<>();

    @OneToMany(mappedBy = "calendar")
    private List<Schedule> schedules = new ArrayList<>();

    public void addSchedule(Schedule schedule) {

        this.schedules.add(schedule);
        if (schedule.getCalendar() != this) {
            schedule.setCalendar(this);
        }
    }
}
