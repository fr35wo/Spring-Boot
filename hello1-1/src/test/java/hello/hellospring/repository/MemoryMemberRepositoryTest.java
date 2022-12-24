package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//리포지토리에 구현한 코드가 정상 동작하는지 테스트 케이스 작성
public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();


    //클리어 하지 않으면 테스트시 오류 발생 가능성 있다. 매우 중요
    @AfterEach //해당 annotation 이 달린 메서드가 각 테스트 메서드 이후에 실행된다.
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();
        //같은지 다른지 결과 출력
        Assertions.assertEquals(member, result);
    }
    @Test
    public void findByName(){

        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        //shift + f6 하면 member1을 member2로 한번에 바꾸기 가능
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        //when
        List<Member> result = repository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
    }




}
