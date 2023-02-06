package basics.core;

import basics.core.member.Grade;
import basics.core.member.Member;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;
import basics.core.order.Order;
import basics.core.order.service.OrderService;
import basics.core.order.service.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        MemberService memberService = new MemberServiceImpl();
        OrderService orderService = new OrderServiceImpl();
        long memberId = 1L;

        Member member = new Member(memberId, "memberA", Grade.VIP);

        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        System.out.println("order = " + order);
    }
}
