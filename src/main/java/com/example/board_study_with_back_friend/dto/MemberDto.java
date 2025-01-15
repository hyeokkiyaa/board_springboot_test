package com.example.board_study_with_back_friend.dto;

import com.example.board_study_with_back_friend.controller.request.MemberRequest;
import com.example.board_study_with_back_friend.domain.Member;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class MemberDto {
    private Long id;
    private String name;
    private Integer age;


    public static MemberDto from(Member member) {
        return MemberDto.builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .build();
    }

    public static MemberDto from(MemberRequest memberRequest) {
        return MemberDto.builder()
                .name(memberRequest.getName())
                .age(memberRequest.getAge())
                .build();
    }
}
