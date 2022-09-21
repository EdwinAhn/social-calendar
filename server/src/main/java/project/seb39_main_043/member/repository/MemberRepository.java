package project.seb39_main_043.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.seb39_main_043.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
