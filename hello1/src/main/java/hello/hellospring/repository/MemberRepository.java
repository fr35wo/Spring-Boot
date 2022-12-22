package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

//저장소
//회원 리포지토리 인터페이스
public interface MemberRepository {
    Member save(Member member); //save기능
    Optional<Member> findById(Long id); //null을 optional로 감싸 반환하기 위해 optional을 쓴다.
    Optional<Member> findByName(String name);
    List<Member> findAll();


}
