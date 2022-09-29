package project.seb39_main_043.calendar.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;
import project.seb39_main_043.calendar.dto.CalendarMemberResponseDto;
import project.seb39_main_043.calendar.dto.CalendarPatchDto;
import project.seb39_main_043.calendar.dto.CalendarPostDto;
import project.seb39_main_043.calendar.dto.CalendarResponseDto;
import project.seb39_main_043.calendar.entity.Calendar;
import project.seb39_main_043.calendar.entity.CalendarMember;
import project.seb39_main_043.member.entity.Member;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper
@Component
public class CalendarMapper {

    public Calendar calendarPostDtoToCalendar(CalendarPostDto calendarPostDto) {
        if (calendarPostDto == null) {
            return null;
        } else {
            Calendar calendar = new Calendar();

            List<CalendarMember> calendarMembers = calendarPostDto.getCalendarMembers().stream()
                    .map(calendarMemberDto -> {
                        CalendarMember calendarMember = new CalendarMember();
                        Member member = new Member();
                        member.setMemberId(calendarMemberDto.getMemberId());
                        member.setEmail(calendarMemberDto.getEmail());
                        member.setName(calendarMemberDto.getName());
                        calendarMember.addCalendar(calendar);
                        calendarMember.addMember(member);

                        return calendarMember;
                    }).collect(Collectors.toList());

            calendar.setTitle(calendarPostDto.getTitle());
            calendar.setCalendarMembers(calendarMembers);

            return calendar;
        }
    }

    public Calendar calendarPatchDtoToCalendar(CalendarPatchDto calendarPatchDto) {
        if (calendarPatchDto == null) {
            return null;
        } else {
            Calendar calendar = new Calendar();
            calendar.setCalendarId(calendarPatchDto.getCalendarId());
            calendar.setTitle(calendarPatchDto.getTitle());
            calendar.setCalendarImg(calendarPatchDto.getCalendarImg());

            return calendar;
        }
    }

    public CalendarResponseDto calendarToCalendarResponseDto(Calendar calendar) {
        if (calendar == null) {
            return null;
        } else {
            List<CalendarMember> calendarMembers = calendar.getCalendarMembers();

            CalendarResponseDto calendarResponseDto = new CalendarResponseDto();
            calendarResponseDto.setCalendarId(calendar.getCalendarId());
            calendarResponseDto.setTitle(calendar.getTitle());
            calendarResponseDto.setCalendarImg(calendar.getCalendarImg());
            calendarResponseDto.setCalendarMembers(
                    calendarMembersToCalendarMemberResponseDtos(calendarMembers)
            );

            return calendarResponseDto;
        }
    }

    public List<CalendarMemberResponseDto> calendarMembersToCalendarMemberResponseDtos(List<CalendarMember> calendarMembers) {

        return calendarMembers.stream()
                .map(calendarMember -> CalendarMemberResponseDto
                        .builder()
                        .memberId(calendarMember.getMember().getMemberId())
                        .email(calendarMember.getMember().getEmail())
                        .name(calendarMember.getMember().getName())
                        .build())
                .collect(Collectors.toList());
    }

    public List<CalendarResponseDto> calendarToCalendarResponseDtos(List<Calendar> calendars) {
        if (calendars == null) {
            return null;
        } else {
            List<CalendarResponseDto> list = new ArrayList<>(calendars.size());
            for (Calendar calendar : calendars) {
                list.add(calendarToCalendarResponseDto(calendar));
            }
            return list;
        }
    }
}
