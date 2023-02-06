package basics.core.discount;

import basics.core.member.Member;

public interface DiscountPolicy {

    int discount(Member member,int price);

}
