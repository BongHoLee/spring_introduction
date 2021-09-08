package userorder.userorder.discount;

import userorder.userorder.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
