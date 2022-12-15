package Team43.SocialCalendar.member.image.controller;

import Team43.SocialCalendar.member.image.dto.MemberImgPostDto;
import Team43.SocialCalendar.member.image.entity.MemberImg;
import Team43.SocialCalendar.member.image.mapper.MemberImgMapper;
import Team43.SocialCalendar.member.image.service.MemberImgService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/members/img")
public class MemberImgController {
    private final MemberImgService memberImgService;
    private final MemberImgMapper mapper;

    public MemberImgController(MemberImgService memberImgService, MemberImgMapper memberImgMapper) {
        this.memberImgService = memberImgService;
        this.mapper = memberImgMapper;
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity postMemberImg(@RequestPart MemberImgPostDto memberImgPostDto,
                                        @RequestPart MultipartFile memberImage) {

        MemberImg memberImg = memberImgService.uploadMemberImg(mapper.memberImgPostDtoToMemberImg(memberImgPostDto), memberImage);

        return new ResponseEntity<>(mapper.memberImgToMemberImgResponseDto(memberImg), HttpStatus.CREATED);
    }
}
