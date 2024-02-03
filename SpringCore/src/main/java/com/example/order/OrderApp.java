package com.example.order;

import com.example.member.Grade;
import com.example.member.Member;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.springcore.AppConfig;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order = " + order);

    }
}
