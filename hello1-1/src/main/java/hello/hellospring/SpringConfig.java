package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

//자바 코드로 직접 스프링 빈 등록하기
@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired
    public SpringConfig(DataSource datasource) {
        this.dataSource = datasource;
    }


    @Bean
    //이 로직을 호출해서 스프링 빈에 등록해준다.
    public MemberService memberService(){
        //생성자에 뭘 넣어줘야함 (괄호 안에) 그럴때 ctrl + p
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        //멤버 서비스와 메모리 멤버 리포지토리를 연결
        //return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
    //구현체만 바꿔끼기 할 수 있다. 다형성활용, 객체 지향의 필요성,스프링의 DI사용이유
    //jdbc리포지토리 사용
}
