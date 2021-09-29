package userorder.userorder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import userorder.userorder.Order.OrderService;
import userorder.userorder.Order.OrderServiceImpl;
import userorder.userorder.discount.DiscountPolicy;
import userorder.userorder.discount.FixDiscountPolicy;
import userorder.userorder.member.MemberRepository;
import userorder.userorder.member.MemberService;
import userorder.userorder.member.MemberServiceImpl;
import userorder.userorder.member.MemoryMemberRepository;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
