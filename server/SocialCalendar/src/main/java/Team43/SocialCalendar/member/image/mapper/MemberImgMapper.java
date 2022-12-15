package Team43.SocialCalendar.member.image.mapper;

import Team43.SocialCalendar.member.entity.Member;
import Team43.SocialCalendar.member.image.dto.MemberImgPostDto;
import Team43.SocialCalendar.member.image.dto.MemberImgResponseDto;
import Team43.SocialCalendar.member.image.entity.MemberImg;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MemberImgMapper {
    default MemberImg memberImgPostDtoToMemberImg(MemberImgPostDto memberImgPostDto) {
        MemberImg memberImg = new MemberImg();
        Member member = new Member();

        member.setMemberId(memberImgPostDto.getMemberId());

        memberImg.setMember(member);
        memberImg.setImg(memberImgPostDto.getImg());

        return memberImg;
    }

    default MemberImgResponseDto memberImgToMemberImgResponseDto(MemberImg memberImg) {
        MemberImgResponseDto memberImgResponseDto = new MemberImgResponseDto();

        memberImgResponseDto.setMemberImgId(memberImg.getMemberImgId());
        memberImgResponseDto.setMember(memberImg.getMember());
        memberImgResponseDto.setImg(memberImg.getImg());

        return memberImgResponseDto;
    }
}
