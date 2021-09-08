package userorder.userorder.order;

import org.junit.jupiter.api.Test;
import userorder.userorder.Order.Order;
import userorder.userorder.Order.OrderService;
import userorder.userorder.Order.OrderServiceImpl;
import userorder.userorder.discount.FixDiscountPolicy;
import userorder.userorder.member.*;

public class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
    OrderService orderService = new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
    }
}
