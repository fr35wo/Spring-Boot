package com.example.springcore;

import com.example.discount.DiscountPolicy;
import com.example.discount.FixDiscountPolicy;
import com.example.discount.RateDiscountPolicy;
import com.example.member.MemberService;
import com.example.member.MemberServiceImpl;
import com.example.member.MemoryMemberRepository;
import com.example.order.OrderService;
import com.example.order.OrderServiceImpl;

public class AppConfig { //실제 동작에 필요한 구현 객체 생성
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy(){
        return new RateDiscountPolicy();
    }

}
