package com.sieun.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean next, prev; // 다음 이전 페이지
	private int total;
	private Criteria cri;
	
	//mapper에서 시작할 페이지와 뿌려줄 갯수 , 총 개시물 갯수 
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		
								
		this.endPage =(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage=endPage-9;
					
		//총 76페이지일시 7페이지가 아니라 8페이지가 나와야 함으로 반올림을 한다.
		this.realEnd=(int)(Math.ceil(total*0.1/cri.getAmount()));
		
		if(realEnd <endPage) {
			this.endPage=realEnd;
		}
		
		this.prev=this.startPage>1; //이전 버튼 시작페이지가 1보다 크면 생성
		this.next=this.endPage<this.realEnd;
		
	}
	
	
	
	
}
