package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

//회원 서비스 개발
//테스트 시 이 클래스에서 ctrl + shift + t

@Service //스프링이 멤버 서비스를 스프링 컨테이너에 등록해주는 어노테이션
public class MemberService {

    //서비스 구현하려면 멤버 리포지토리가 필요하겠지?
    private final MemberRepository memberRepository;


    //내가 직접 new 하지 않고 외부에서 넣어줌 (memberService입장에서) 이것이 DI이다. Dependency Injection 의존관계 주입
    @Autowired //멤버 컨트롤러는 멤버 서비스 필요 / 멤버 서비스는 멤버 리포지토리 필요
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입 (멤버리포지토리 에다가 세이브만 호출하면 됨)
    public long join(Member member) {
        //같은 이름있는 중복 회원X
        ValidateDuplicateMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();


    }
    //메서드 추출 ctrl + alt + m
    private void ValidateDuplicateMember(Member member) {
        Optional<Member> result = memberRepository.findByName(member.getName()); //변수 추출하기 ctrl + alt + v
        //ifPresent 메서드는 result에 null이 아닌 어떤 값이 있으면 동작 , optional이기 때문에 가능
        //optional은 NPE방지 , Wrapper 클래스 이기 때문에 여러 메소드 사용가능
        result.ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    //전체 회원 조회
    public List<Member> findByMembers() {
        return memberRepository.findAll();
    }

    //한명 조회회
   public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}
