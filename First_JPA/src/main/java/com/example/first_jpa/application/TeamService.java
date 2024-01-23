package com.example.first_jpa.application;

import com.example.first_jpa.api.dto.request.TeamSaveReqDto;
import com.example.first_jpa.api.dto.response.MemberResDto;
import com.example.first_jpa.domain.Member;
import com.example.first_jpa.domain.Part;
import com.example.first_jpa.domain.Team;
import com.example.first_jpa.domain.repository.MemberRepository;
import com.example.first_jpa.domain.repository.TeamRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeamService {

    private final TeamRepository teamRepository;
    private final MemberRepository memberRepository;

    public TeamService(TeamRepository teamRepository, MemberRepository memberRepository) {
        this.teamRepository = teamRepository;
        this.memberRepository = memberRepository;
    }

    // 파트별 팀 생성
    //복잡한 객체의 생성 과정 및 표현 방법을 분리해 동일한 생성 절차에서 서로 다른 표현 결과를 만들 수 있게 하는 패턴
    @Transactional
    public Team createTeam(TeamSaveReqDto teamSaveReqDto){
        Team team = Team.builder()
                .teamName(teamSaveReqDto.getTeamName())
                .part(teamSaveReqDto.getPart())
                .build();

        return teamRepository.save(team);
    }



    public List<MemberResDto> teamMemberList(Long teamId) {
        Team team = teamRepository.findById(teamId).orElseThrow();
        List<Member> memberList = team.getMemberList();

        List<MemberResDto> memberResDtoList = new ArrayList<>();
        for (Member member : memberList) {
            MemberResDto memberResDto = new MemberResDto(
                    member.getMemberId(),
                    member.getName(),
                    member.getAge(),
                    member.getPart());

            memberResDtoList.add(memberResDto);
        }

        return memberResDtoList;
    }


}
