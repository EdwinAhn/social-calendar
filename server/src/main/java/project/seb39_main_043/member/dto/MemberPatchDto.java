package project.seb39_main_043.member.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberPatchDto {

    private Long memberId;
    private String memberImg;
    private String name;
    private String statusMessage;
}
