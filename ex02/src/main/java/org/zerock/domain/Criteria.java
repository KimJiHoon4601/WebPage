package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	//����¡ ó���� ���� ����
	private int pageNum;
	private int amount;
	
	
	//�Է°��� ���� ����
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10,"ALL","");
		System.out.println("������ȣ��==============");
	}
	
	public Criteria(int pageNum , int amount, String type, String keyword) {
		this.pageNum = pageNum;
		this.amount  = amount;
		this.type 	 = type;
		this.keyword = keyword;
	}
}
