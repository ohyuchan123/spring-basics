package basics.core.config;

import basics.core.discount.DiscountPolicy;
import basics.core.discount.FixDiscountPolicy;
import basics.core.member.repository.MemberRepository;
import basics.core.member.repository.MemoryMemberRepository;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import basics.core.order.service.OrderService;
import basics.core.order.service.OrderServiceImpl;

public class AppConfig {
    //AppConfig는 애플리케이션의 실제 동작에 필요한 구현 객체를 생성한다.
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new FixDiscountPolicy();
    }
}
