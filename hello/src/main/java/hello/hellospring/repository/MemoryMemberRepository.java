package hello.hellospring.repository;


import hello.hellospring.domain.Member;

import java.util.*;

//회원 리포지토리 메모리 구현체
public class MemoryMemberRepository implements MemberRepository{
    //저장하기 위해 Map사용
    private static Map<Long, Member> store = new HashMap<>();
    //키값생성
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return  Optional.ofNullable(store.get(id));

    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                //넘어온 name과 같은지 확인
                .filter(member -> member.getName().equals(name))
                .findAny();

    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //테스트 에서 클리어 위한 메소드
    public void clearStore(){
        store.clear();
    }

}
