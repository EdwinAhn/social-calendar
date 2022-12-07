package Team43.SocialCalendar.member.image.service;

import Team43.SocialCalendar.member.image.entity.MemberImg;
import Team43.SocialCalendar.member.image.repository.MemberImgRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class MemberImgService {
    private final MemberImgRepository memberImgRepository;
    private final StorageService storageService;

    public MemberImgService(MemberImgRepository memberImgRepository, StorageService storageService) {
        this.memberImgRepository = memberImgRepository;
        this.storageService = storageService;
    }

    public MemberImg uploadMemberImg(MemberImg memberImg, MultipartFile memberImage) {
        memberImg.setImg(memberImage.getOriginalFilename());

        storageService.store(memberImage);
        return memberImgRepository.save(memberImg);
    }
}
