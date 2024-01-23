package com.example.first_jpa.api.dto.request;


import com.example.first_jpa.domain.Part;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class TeamSaveReqDto {

    private Part part;

    private String teamName;

    public TeamSaveReqDto(Part part, String teamName) {
        this.part = part;
        this.teamName = teamName;
    }

    public Part getPart() {
        return part;
    }

    public String getTeamName() {
        return teamName;
    }
}
