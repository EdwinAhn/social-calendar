package Team43.SocialCalendar.member.image.dto;

import Team43.SocialCalendar.member.entity.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberImgResponseDto {
    private long memberImgId;

    private long memberId;
    private String img;

    public void setMember(Member member) {
        this.memberId = member.getMemberId();
    }
}
