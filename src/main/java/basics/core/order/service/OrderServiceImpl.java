package basics.core.order.service;

import basics.core.discount.DiscountPolicy;
import basics.core.discount.FixDiscountPolicy;
import basics.core.member.Member;
import basics.core.member.repository.MemberRepository;
import basics.core.member.repository.MemoryMemberRepository;
import basics.core.order.Order;

public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
