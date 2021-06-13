package com.sieun.domain;


import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //생성자 자동 생성 
public class Criteria {
	
	private int pageNum;//현재 페이지 
	private int amount;//그 페이지에 뿌려줄 갯수 
	private String type;
	private String keyword;

	
	//기본생성자->페이지 디폴트 값 
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	
	//myBatis는 get만 찾는다
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	//쿼리 스트링
	public String getList() {
		UriComponentsBuilder builder= UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.getKeyword())
				.queryParam("keyword",getKeyword());
		
		return builder.toUriString();
		
	}
	
	

}
