package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest //스프링 컨테이너와 함께 테스트 실행
@Transactional //테스트시 데이터베이스에 넣은 데이터 알아서 지움, 다음테스트에 영향 주지 않는다
public class MemberServiceIntegrationTest {

    @Autowired
    MemberService memberService;

    //클리어
    @Autowired
    MemberRepository memberRepository;


    @Test
        //테스트 메서드 이름은 한글도 상관없음
        //테스트 코드 문법 사용하는게 좋다(given-when-then)
    void 회원가입() {
        //given 뭔가가 주어졌는데
        Member member = new Member();
        member.setName("spring");

        //when 이걸 실행했을때
        Long saveId = memberService.join(member);

        //then 결과가 이게 나와야해
        Member findMember = memberService.findOne(saveId).get();
        //assertThat 은 두 값 비교
        assertThat(member.getName()).isEqualTo(findMember.getName());

    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2= new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        //뒤의 로직을 실행할건데 밑의 예외가 터져야한다. 람다식 사용
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        /* try - catch 사용한 예외처리
        try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다");
        }*/


        //then

    }



}
