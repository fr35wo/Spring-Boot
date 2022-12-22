package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    @Bean
    //이 로직을 호출해서 스프링 빈에 등록해준다.
    public MemberService memberService(){
        //생성자에 뭘 넣어줘야함 (괄호 안에) 그럴때 ctrl + p
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
    //멤버 서비스와 멤버 리포지토리를 연결

}
