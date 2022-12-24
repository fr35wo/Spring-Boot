package hello.hellospring.controller;


import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

//컴포넌트 스캔과 자동 의존관계 설정
//회원 컨트롤러가 회원서비스와 회원 리포지토리를 사용할 수 있게 의존관계를 준비하자.
@Controller
//스프링이 컨테이너를 만들어서 멤버 컨트롤러 객체를 생성해서 스프링이 넣어둔다. 그리고 스프링이 관리 (스프링 빈 이 관리된다.)
public class MemberController {

    private final MemberService memberService;

    //공용으로 쓰기위한 연결 위한 생성자
    @Autowired //멤버 서비스를 스프링이 스프링 컨테이너에 있는 멤버 서비스를 가져다가 연결
    //생성자를 통해서 멤버 서비스가 멤버 컨트롤러에 주입된다. (생성자 주입) DI의 3가지 방법중 하나
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    //필드 주입 (별로 안좋음, 바꾸기 힘듬)
    //@AutoWired private MemberService memberService

    //setter 주입
    //public하게 노출되어있기 때문에 안좋음

    //public setMemberService(MemberService memberService) {
    //        this.memberService = memberService;
    //    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("/members/new")
    public String create(MemberForm form) {
        Member member = new Member();
        member.setName(form.getName());

        memberService.join(member);

        return "redirect:/";
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findByMembers();
        model.addAttribute("members",members);
        return "members/memberList";
    }



}
