package basics.core.member.repository;

import basics.core.member.Member;

public interface MemberRepository {

    void save(Member member);

    Member findById(Long memberId);

}
