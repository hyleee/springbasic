package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService{

    // private final MemberRepository memberRepository=new MemoryMemberRepository();

    // private final DiscountPolicy discountPolicy=new FixDiscountPolicy();
    // interface에만 의존하도록. ( = 구체화에는 의존하지않고 추상화에만 의존하도록 변경) 우변&final 삭제
    // final : 무조건 값을 할당
    // private DiscountPolicy discountPolicy=new FixDiscountPolicy();
    // 인터페이스에서는 객체 생성만 하면 됐지 생성 및 정책 선택까지 해버리면
    // 연극에서 배우가 섭외까지 하는 거나 마찬가지

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member=memberRepository.findById(memberId);
        int discountPrice=discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }
}
