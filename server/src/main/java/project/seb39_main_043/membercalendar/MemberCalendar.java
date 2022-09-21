package project.seb39_main_043.membercalendar;

import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.member.entity.Member;

import javax.persistence.*;

@Entity
public class MemberCalendar {

    @Id
    @GeneratedValue
    private Long memberCalendarId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;
}
