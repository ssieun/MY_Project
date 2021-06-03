package com.sieun.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
	
	private int startPage;
	private int endPage;
	private int realEnd;
	private boolean next, prev; // ���� ���� ������
	private int total;
	private Criteria cri;
	
	//mapper���� ������ �������� �ѷ��� ���� , �� ���ù� ���� 
	public PageDTO(Criteria cri, int total) {
		this.cri=cri;
		this.total=total;
		
								
		this.endPage =(int)(Math.ceil(cri.getPageNum()/10.0))*10;
		this.startPage=endPage-9;
					
		//�� 76�������Ͻ� 7�������� �ƴ϶� 8�������� ���;� ������ �ݿø��� �Ѵ�.
		this.realEnd=(int)(Math.ceil(total*0.1/cri.getAmount()));
		
		if(realEnd <endPage) {
			this.endPage=realEnd;
		}
		
		this.prev=this.startPage>1; //���� ��ư ������������ 1���� ũ�� ����
		this.next=this.endPage<this.realEnd;
		
	}
	
	
	
	
}
