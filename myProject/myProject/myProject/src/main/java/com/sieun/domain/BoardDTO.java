package com.sieun.domain;

import lombok.Data;

@Data
public class BoardDTO {
	
	private Long boardNum;
	private String memberId;
	private String boardTitle;
	private String boardContent;
	private String boardDate;
	private String updateDate;
	private String category;

	
}
