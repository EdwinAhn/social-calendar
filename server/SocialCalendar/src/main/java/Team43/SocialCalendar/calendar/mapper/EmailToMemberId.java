package Team43.SocialCalendar.calendar.mapper;

import Team43.SocialCalendar.calendar.service.CalendarAttendeeService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class EmailToMemberId {

    private CalendarAttendeeService calendarAttendeeService;
}
