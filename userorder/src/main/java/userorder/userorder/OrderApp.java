package userorder.userorder;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import userorder.userorder.Order.Order;
import userorder.userorder.Order.OrderService;
import userorder.userorder.member.Grade;
import userorder.userorder.member.Member;
import userorder.userorder.member.MemberService;

public class OrderApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);
    }
}
