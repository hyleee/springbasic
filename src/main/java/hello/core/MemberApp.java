package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.boot.ApplicationArguments;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig appConfig=new AppConfig();
        //MemberService memberService=appConfig.memberService();

        ApplicationContext applicationContext= new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        //  psvm 단축키 사용
        // MemberService memberService=new MemberServiceImpl();
        Member member = new Member(1L, "memberA", Grade.VIP);
        // 우변만 입력한 채로 단축키 ctrl + alt + v 사용 -> 리팩토링?
        // 1L의 L: longtype
        // 좌변의 member는 단순히 변수명
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        // 우변만 입력한 채로 단축키 ctrl + alt + v 사용 -> 리팩토링?
        // 좌변의 findMember는 단순히 변수명
        System.out.println("new member="+member.getName());
        System.out.println("find Member="+findMember.getName());
        //soutv 단축키 사용해서 인자 선택 : System.out.println()

    }
}
