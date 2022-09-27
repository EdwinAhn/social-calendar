package project.seb39_main_043.member.service;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import project.seb39_main_043.member.entity.Member;
import project.seb39_main_043.member.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member createMember(Member member) {
        verifyExistsEmail(member.getEmail());


        return memberRepository.save(member);
    }

    public Member updateMember(Member member) {

        Member findMember = findVerifiedMember(member.getMemberId());
        Optional.ofNullable(member.getName())
                .ifPresent(name -> findMember.setName(name));
        Optional.ofNullable(member.getMemberImg())
                .ifPresent(memberImg -> findMember.setMemberImg(memberImg));
        Optional.ofNullable(member.getStatusMessage())
                .ifPresent(statusMsg -> findMember.setStatusMessage(statusMsg));

        return memberRepository.save(findMember);
    }

    public Member findMember(long memberId) {

        return findVerifiedMember(memberId);
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public void deleteMember(long memberId) {
        Member findMember = findVerifiedMember(memberId);
        memberRepository.delete(findMember);
    }

    private void verifyExistsEmail(String email) {
        Optional<Member> member = memberRepository.findByEmail(email);
        if (member.isPresent()) {
            throw new DuplicateKeyException("이미 사용중인 이메일입니다.");
        }
    }

    private Member findVerifiedMember(Long memberId) {

        Optional<Member> optionalMember = memberRepository.findById(memberId);
        Member findMember = optionalMember.orElseThrow(() ->
                new IllegalArgumentException("유효하지 않은 회원입니다."));    // 이거 뭘로 잡아야될지 모르겠음..

        return findMember;
    }
}
