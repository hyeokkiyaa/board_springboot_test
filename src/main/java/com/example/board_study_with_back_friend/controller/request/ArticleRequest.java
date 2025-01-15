package com.example.board_study_with_back_friend.controller.request;

import com.example.board_study_with_back_friend.domain.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ArticleRequest {
  private String title;
  private String content;
  private Long memberId;

  public ArticleRequest(String title, String content){
    this.title = title;
    this.content = content;
  }

  public ArticleRequest(String title, String content, Long memberId){
    this.title = title;
    this.content = content;
    this.memberId = memberId;
  }

}
