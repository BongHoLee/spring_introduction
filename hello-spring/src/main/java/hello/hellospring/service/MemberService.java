package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository repository) {
        this.memberRepository = repository;
    }

    /**
     * 회원 가입
     */
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        // 같은 이름의 회원은 x. 만일 존재한다면 exception
        memberRepository.findByName(member.getName())
                .ifPresent(duplicateMember -> {
                    throw new IllegalStateException("이미 존재하는 이름입니다.");
                });
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
