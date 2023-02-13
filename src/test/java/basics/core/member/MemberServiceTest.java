package basics.core.member;

import basics.core.config.AppConfig;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MemberServiceTest {

//    MemberService memberService = new MemberServiceImpl(memberRepository);
    AppConfig appConfig = new AppConfig();
    MemberService memberService = appConfig.memberService();

    @Test
    void join(){
        //given
        Member member = new Member(1L,"memberApp",Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

}
