package com.example.first_jpa.controller;

import com.example.first_jpa.api.dto.request.TeamSaveReqDto;
import com.example.first_jpa.api.dto.response.MemberResDto;
import com.example.first_jpa.application.TeamService;
import com.example.first_jpa.domain.Part;
import com.example.first_jpa.domain.Team;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {

    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    //요청값은 핸들러 메서드의 파라미터 통해 가져옴
    //ResponseEntity는 사용자의 HttpRequest에 대한 응답 데이터를 포함하는 클래스
    @PostMapping("/api/team/create")
    public Team createTeam(@RequestBody TeamSaveReqDto teamSaveReqDto){
        // 요청값 service로 넘기기
        // service는 repository를 활용해 데이터를 DB에 저장하고, 반환할 것이다.
        return teamService.createTeam(teamSaveReqDto);
    }

    @GetMapping("/api/team/list")
    public ResponseEntity<List<MemberResDto>> teamList(@RequestParam("teamId") Long teamId) {
        return new ResponseEntity<>(teamService.teamMemberList(teamId), HttpStatus.OK);
    }
}
