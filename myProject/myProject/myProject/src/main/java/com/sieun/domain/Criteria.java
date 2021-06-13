package com.sieun.domain;


import org.springframework.web.util.UriComponentsBuilder;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor //������ �ڵ� ���� 
public class Criteria {
	
	private int pageNum;//���� ������ 
	private int amount;//�� �������� �ѷ��� ���� 
	private String type;
	private String keyword;

	
	//�⺻������->������ ����Ʈ �� 
	public Criteria() {
		this(1,10);
	}
	
	public Criteria(int pageNum, int amount) {
		this.pageNum=pageNum;
		this.amount=amount;
	}

	
	//myBatis�� get�� ã�´�
	public String[] getTypeArr() {
		return type == null ? new String[] {} : type.split("");
	}
	
	//���� ��Ʈ��
	public String getList() {
		UriComponentsBuilder builder= UriComponentsBuilder.fromPath("")
				.queryParam("pageNum", this.pageNum)
				.queryParam("amount", this.amount)
				.queryParam("type", this.getKeyword())
				.queryParam("keyword",getKeyword());
		
		return builder.toUriString();
		
	}
	
	

}
