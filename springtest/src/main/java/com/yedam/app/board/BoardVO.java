package com.yedam.app.board;

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
	private String subject;
	private String contents;
	private int no;
	private String lastpost;
	private int views;
	private String filename;
	
}
