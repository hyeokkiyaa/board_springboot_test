package com.example.board_study_with_back_friend.controller;

import com.example.board_study_with_back_friend.controller.request.MemberRequest;
import com.example.board_study_with_back_friend.controller.response.MemberResponse;
import com.example.board_study_with_back_friend.domain.Member;
import com.example.board_study_with_back_friend.dto.MemberDto;
import com.example.board_study_with_back_friend.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members")
    public ResponseEntity<List<MemberResponse>> showAllMembers() {
        List<MemberResponse> members = memberService.findAll().stream().map(MemberResponse::from).toList();
        return ResponseEntity.ok().body(members);
    }

    @PostMapping("/member")
    public ResponseEntity<MemberResponse> addMember(@RequestBody MemberRequest memberRequest) {
        MemberDto memberDto = memberService.save(memberRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<MemberResponse> deleteMember(@PathVariable Long id) {
        memberService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/member/{id}")
    public ResponseEntity<MemberResponse> updateMember(@PathVariable Long id, @RequestBody MemberRequest memberRequest) {
        MemberDto memberDto = memberService.update(id, memberRequest);
        return ResponseEntity.ok().body(MemberResponse.from(memberDto));
    }
}
