package project.seb39_main_043.member.repository;

////@SpringBootTest
//class UserRepositoryTest {
//
//    @Autowired MemberRepository userRepository;
//
//    @Test
//    @DisplayName("Auditing 기능 적용")
//    void findUser() {
//
//        //given
//        Member user = Member.builder()
//                .name("hello")
//                .email("hallo@naver.com")
//                .password("asdf")
//                .build();
//
//        //when
//        Member savedUser = userRepository.save(user);
//
//        //then
//        assertNotNull(savedUser.getCreatedAt());
//        assertNotNull(savedUser.getModifiedAt());
//    }
//
//}