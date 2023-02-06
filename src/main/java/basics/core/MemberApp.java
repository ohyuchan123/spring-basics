package basics.core;

import basics.core.member.Grade;
import basics.core.member.Member;
import basics.core.member.service.MemberService;
import basics.core.member.service.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl();
        Member ma = new Member(1L, "memberApp", Grade.VIP);
        memberService.join(ma);

        Member fm = memberService.findMember(1L);
        System.out.println("new member = "+ma.getName());
        System.out.println("findmember = "+fm.getName());
    }
}
