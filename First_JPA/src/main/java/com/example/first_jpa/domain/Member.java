package com.example.first_jpa.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) //기본 생성자 만듬
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //기본키생성 데이터베이스에 위임
    private Long memberId;

    private String name;

    private int age;

    @Enumerated(EnumType.STRING) //db에 문자열로 들어감
    private Part part;

    @ManyToOne(fetch = FetchType.LAZY) //지연 로딩
    @JoinColumn(name = "team_id") //외래키 매핑 시 사용
    private Team team;

    @Builder
    public Member(String name, int age, Part part) {
        this.name = name;
        this.age = age;
        this.part = part;
    }

    public void teamSetting(Team team) {
        this.team = team;
    }
}