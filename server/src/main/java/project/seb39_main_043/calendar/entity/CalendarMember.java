package project.seb39_main_043.calendar.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import project.seb39_main_043.common.BaseEntity;
import project.seb39_main_043.member.entity.Member;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class CalendarMember extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarMemberId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "calendar_id")
    private Calendar calendar;

    public void addMember(Member member) {
        this.member = member;
        if (!this.member.getCalendarMembers().contains(this)) {
            this.member.getCalendarMembers().add(this);
        }
    }

    public void addCalendar(Calendar calendar) {
        this.calendar = calendar;
        if (!this.calendar.getCalendarMembers().contains(this)) {
            this.calendar.getCalendarMembers().add(this);
        }
    }
}
