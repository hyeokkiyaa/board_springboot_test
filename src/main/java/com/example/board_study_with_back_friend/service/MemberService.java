package com.example.board_study_with_back_friend.service;

import com.example.board_study_with_back_friend.controller.request.MemberRequest;
import com.example.board_study_with_back_friend.domain.Member;
import com.example.board_study_with_back_friend.dto.MemberDto;
import com.example.board_study_with_back_friend.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public List<MemberDto> findAll() {
        List<Member> members = memberRepository.findAll();
        return members.stream().map(MemberDto::from).toList();
    }

    public MemberDto save(MemberRequest memberRequest) {
        return MemberDto.from(memberRepository.save(Member.from(memberRequest)));
    }

    public void deleteById(Long id) {
        memberRepository.deleteById(id);
    }

    @Transactional
    public MemberDto update(Long id, MemberRequest memberRequest) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 멤버 없습니다"));
        member.update(MemberDto.from(memberRequest));
        return MemberDto.from(member);
    }
}
