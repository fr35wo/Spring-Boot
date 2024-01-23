package com.example.first_jpa.api.dto.request;

import com.example.first_jpa.domain.Part;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MemberSaveReqDto {

    private String name;
    private int age;
    private Part part;

    public MemberSaveReqDto(String name, int age, Part part) {
        this.name = name;
        this.age = age;
        this.part = part;
    }
}
