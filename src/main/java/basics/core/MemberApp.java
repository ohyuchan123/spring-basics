package basics.core;

import basics.core.config.AppConfig;
import basics.core.member.Grade;
import basics.core.member.Member;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        MemberService memberService = new MemberServiceImpl(memberRepository);

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //ApplicationContext를 스프링 컨테이너라고 한다. 이는 인터페이스인데, 이는 다양한 구현클래스가 있다는 것을의미한다.
        //아래에는 어노테이션 기반인 AnnotationConfigApplicationContext 클래스를 사용하였으나
        //XML 기반의 컨테이너를 사용할 수 있다.
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member ma = new Member(1L, "memberA", Grade.VIP);
        memberService.join(ma);

        Member fm = memberService.findMember(1L);
        System.out.println("new member = "+ma.getName());
        System.out.println("findmember = "+fm.getName());
    }
}
