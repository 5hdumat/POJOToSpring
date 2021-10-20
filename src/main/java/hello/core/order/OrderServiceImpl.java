package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository;
    private final Map<String, DiscountPolicy> discountPolicyMap;

    public OrderServiceImpl(MemberRepository memberRepository, Map<String, DiscountPolicy> discountPolicyMap) {
        this.memberRepository = memberRepository;
        this.discountPolicyMap = discountPolicyMap;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice, String discountCode) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicyMap.get(discountCode).discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
