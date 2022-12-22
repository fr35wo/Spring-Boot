package hello.hellospring.controller;


import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

//컴포넌트 스캔과 자동 의존관계 설정
//회원 컨트롤러가 회원서비스와 회원 리포지토리를 사용할 수 있게 의존관계를 준비하자.
@Controller
//스프링이 컨테이너를 만들어서 멤버 컨트롤러 객체를 생성해서 스프링이 넣어둔다. 그리고 스프링이 관리 (스프링 빈 이 관리된다.)
public class MemberController {

    private final MemberService memberService;

    //공용으로 쓰기위한 연결 위한 생성자
    @Autowired //멤버 서비스를 스프링이 스프링 컨테이너에 있는 멤버 서비스를 가져다가 연결
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }




}
