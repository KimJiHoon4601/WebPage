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
		this(1,10);
		System.out.println("������ȣ��==============");
	}
	
	public Criteria(int pageNum , int amount) {
		this.pageNum = pageNum;
		this.amount  = amount;
	}
}
