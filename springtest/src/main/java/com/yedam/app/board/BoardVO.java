package com.yedam.app.board;

import java.util.List;

import com.yedam.app.member.MemberVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	private String poster;
	private String boardSubject;
	private String contents;
	private Integer boardNo;
	private String lastpost;
	private int views;
	private String filename;
	private String sortCol;		// 정렬순서
	
	private MemberVO member;	// 작성자
	
	private List<String> nos;
	private int first;
	private int last;
	
	
	
	
}
