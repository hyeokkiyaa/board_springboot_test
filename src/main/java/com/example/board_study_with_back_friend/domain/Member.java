package com.example.board_study_with_back_friend.domain;

import com.example.board_study_with_back_friend.controller.request.MemberRequest;
import com.example.board_study_with_back_friend.dto.MemberDto;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;
    private String name;
    private int age;

    @OneToMany(
            mappedBy = "member",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Article> articles = new ArrayList<>();

    public static Member from(MemberRequest memberRequest) {
        return Member.builder()
                .name(memberRequest.getName())
                .age(memberRequest.getAge())
                .build();
    }

    public Member(MemberDto memberDto){
        this.name = memberDto.getName();
        this.age = memberDto.getAge();
        this.articles = new ArrayList<>();
    }

    public void update(MemberDto memberDto){
        this.name = memberDto.getName();
        this.age = memberDto.getAge();
    }
}
