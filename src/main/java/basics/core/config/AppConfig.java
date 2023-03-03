package basics.core.config;

import basics.core.discount.DiscountPolicy;
import basics.core.discount.FixDiscountPolicy;
import basics.core.discount.RateDiscountPolicy;
import basics.core.member.repository.MemberRepository;
import basics.core.member.repository.MemoryMemberRepository;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import basics.core.order.service.OrderService;
import basics.core.order.service.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration//Bean을 사용하기 위한 과정
public class AppConfig {
    /*
    * @Bean의 구성요소
    * - class : Bean으로 등록할 Java 클래스
    * - id : Bean의 고유 식별자
    * - scope : Bean을 생성하기 위한 방법(singleton,prototype 등)
    * constructor-arg : Bean 생성 시 생성자에 전달할 파라미터
    * property : Bean 생성 시 setter에 전달할 인수*/

    @Bean//Spring에서는 Spring의 DI Container에 의해 관리되는 POJO(Plain Old Java Object)를 Bean이라고 부른다.
    //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    @Bean//private 상태는 불가능
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
