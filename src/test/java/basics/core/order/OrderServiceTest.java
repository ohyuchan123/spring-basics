package basics.core.order;

import basics.core.config.AppConfig;
import basics.core.member.Grade;
import basics.core.member.Member;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import basics.core.order.service.OrderService;
import basics.core.order.service.OrderServiceImpl;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OrderServiceTest {

    AppConfig appConfig = new AppConfig();
    //        MemberService memberService = new MemberServiceImpl(memberRepository);
    //        OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);
    MemberService memberService = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
     void createOrder() {
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}
