package jpabook.jpashop;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class MemberRepository {

    // 이 어노테이션 있으면 스프링 부트가 EntityManager를 주입을 해준다.
    // spring-data-jpa의 AutoConfiguration에서 모두 설정(EntityManagerFactory 등)을 해주는듯
    @PersistenceContext
    private EntityManager em;

    public Long save(Member member) {
        em.persist(member);
        return member.getId();
    }

    public Member find(Long id) {
        return em.find(Member.class, id);
    }

}
