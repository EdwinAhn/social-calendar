package Team43.SocialCalendar.diary.mapper;

import Team43.SocialCalendar.diary.dto.DiaryPostDto;
import Team43.SocialCalendar.diary.dto.DiaryResponseDto;
import Team43.SocialCalendar.diary.entity.Diary;
import Team43.SocialCalendar.member.entity.Member;
import Team43.SocialCalendar.schedule.entity.Schedule;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DiaryMapper {

    default Diary diaryPostDtoToDiary(DiaryPostDto diaryPostDto) {
        Diary diary = new Diary();
        Schedule schedule = new Schedule();
        Member member = new Member();
        schedule.setScheduleId(diaryPostDto.getScheduleId());
        member.setMemberId(diaryPostDto.getMemberId());
        diary.setSchedule(schedule);
        diary.setMember(member);
        diary.setTitle(diaryPostDto.getTitle());
        diary.setContents(diaryPostDto.getContents());
        diary.setDiaryImg(diaryPostDto.getDiaryImg());

        return diary;
    }

    default DiaryResponseDto diaryToDiaryResponseDto(Diary diary) {
        DiaryResponseDto diaryResponseDto = new DiaryResponseDto();

        diaryResponseDto.setDiaryId(diary.getDiaryId());
        diaryResponseDto.setTitle(diary.getTitle());
        diaryResponseDto.setContents(diary.getContents());
        diaryResponseDto.setDiaryImg(diary.getDiaryImg());

        diaryResponseDto.setSchedule(diary.getSchedule());

        diaryResponseDto.setMember(diary.getMember());
        diaryResponseDto.setName(diary.getMember().getName());
        diaryResponseDto.setMemberImg(diary.getMember().getMemberImg());

        diaryResponseDto.setCreatedAt(diary.getCreatedAt());

        return diaryResponseDto;
    }
}
