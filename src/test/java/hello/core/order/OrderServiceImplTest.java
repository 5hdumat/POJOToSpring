package hello.core.order;

import hello.core.AppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceImplTest {
    @Test
    void createOrder() {
        HashMap<String, DiscountPolicy> discountPolicyHashMap = new HashMap<>();

        discountPolicyHashMap.put("fixDiscountPolicy", new FixDiscountPolicy());
        discountPolicyHashMap.put("rateDiscountPolicy", new RateDiscountPolicy());

        MemoryMemberRepository memberRepository = new MemoryMemberRepository();
        memberRepository.save(new Member(1L, "MemberA", Grade.VIP));

        OrderServiceImpl orderService = new OrderServiceImpl(memberRepository, discountPolicyHashMap);
        Order order = orderService.createOrder(1L, "itemA", 10000, "fixDiscountPolicy");

        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }
}