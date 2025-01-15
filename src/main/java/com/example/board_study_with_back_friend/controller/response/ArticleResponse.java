package com.example.board_study_with_back_friend.controller.response;

import com.example.board_study_with_back_friend.dto.ArticleDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleResponse {
	private String title;
	private String content;
	private Long memberId;

	public static ArticleResponse from(ArticleDto articleDto){
		return ArticleResponse.builder()
			.title(articleDto.getTitle())
			.content(articleDto.getContent())
				.memberId(articleDto.getMemberId())
			.build();
	}

	public ArticleResponse(String title, String content, Long memberId) {
		this.title = title;
		this.content = content;
		this.memberId = memberId;
	}

	public ArticleResponse(ArticleDto articleDto) {
		this.title = articleDto.getTitle();
		this.content = articleDto.getContent();
		this.memberId = articleDto.getMemberId();
	}


}
