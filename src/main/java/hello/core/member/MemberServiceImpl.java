package hello.core.member;

public class MemberServiceImpl implements MemberService{

    // private final MemberRepository memberRepository = new MemoryMemberRepository();
    // 우변 삭제 후 생성자 만들기
    // memoryMemberRepository 는  AppConfig에서 다루는거
    private MemberRepository memberRepository;

    // 생성자를 통해서 memorymemberRepository에 의 구현체를 만드는거야. 직접 만드는게 아니구
    // 각 개체의 레퍼런스를 생성자를 통해서 주입
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
        // 객체값이 NULL 이면 save 터짐, 따라서 line5의 우변에서 구현객체 선택 필수
        // MemoryMemberRepository에 있는 save 호출 ( 두다리 건너)
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
