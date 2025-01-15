package com.example.board_study_with_back_friend.controller.response;

import com.example.board_study_with_back_friend.dto.MemberDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MemberResponse {
    private String name;
    private int age;


    public static MemberResponse from(MemberDto memberDto) {
        return MemberResponse.builder()
                .name(memberDto.getName())
                .age(memberDto.getAge())
                .build();
    }
}
