package basics.core.member.service;

import basics.core.member.Member;

public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
