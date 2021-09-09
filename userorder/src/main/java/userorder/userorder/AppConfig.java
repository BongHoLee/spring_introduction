package userorder.userorder;

import userorder.userorder.Order.OrderService;
import userorder.userorder.Order.OrderServiceImpl;
import userorder.userorder.discount.DiscountPolicy;
import userorder.userorder.discount.FixDiscountPolicy;
import userorder.userorder.member.MemberRepository;
import userorder.userorder.member.MemberService;
import userorder.userorder.member.MemberServiceImpl;
import userorder.userorder.member.MemoryMemberRepository;

public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(
                memberRepository(),
                discountPolicy()
        );
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
