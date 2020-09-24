package com.yedam.app.member;

import com.yedam.app.board.BoardVO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberVO {
	private String id;
	private String pw;
	private String gender;
	private String job;
	private String reason;
	private String mailyn;
	private String hobby;
	private String regdate;
	
}
