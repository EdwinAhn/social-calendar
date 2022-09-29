package Team43.SocialCalendar.member.config;

import Team43.SocialCalendar.member.auth.utils.HelloAuthorityUtils;
import Team43.SocialCalendar.member.repository.MemberRepository;
import Team43.SocialCalendar.member.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class JavaConfiguration {

    @Bean
    public MemberService dbMemberService(MemberRepository memberRepository, PasswordEncoder passwordEncoder, HelloAuthorityUtils helloAuthorityUtils) {
        return new MemberService(memberRepository, passwordEncoder, helloAuthorityUtils);
    }
}
