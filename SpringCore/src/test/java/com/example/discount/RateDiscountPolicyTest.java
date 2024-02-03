package com.example.discount;

import com.example.member.Grade;
import com.example.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {

    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10% 할인이 적용")
    void vip_o(){
        Member member = new Member(1L,"memverVIP", Grade.VIP);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP아니면 할인이 적용되지 않아야 한다.")
    void vip_x(){
        Member member = new Member(1L,"memverBASIC", Grade.BASIC);

        int discount = discountPolicy.discount(member,10000);

        Assertions.assertThat(discount).isEqualTo(0);
    }

}