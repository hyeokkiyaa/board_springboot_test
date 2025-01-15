package com.example.board_study_with_back_friend.controller.request;

import lombok.Data;

@Data
public class MemberRequest {
    private String name;
    private int age;

    public MemberRequest(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
