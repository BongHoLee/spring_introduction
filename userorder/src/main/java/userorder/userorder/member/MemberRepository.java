package userorder.userorder.member;

public interface MemberRepository {
    void save(Member member);
    Member findById(Long memberId);
}
