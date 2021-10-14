package org.zerock.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Criteria {
	
	//페이징 처리를 위한 변수
	private int pageNum;
	private int amount;
	
	
	//입력값을 위한 변수
	private String type;
	private String keyword;
	
	public Criteria() {
		this(1,10);
		System.out.println("생성자호출==============");
	}
	
	public Criteria(int pageNum , int amount) {
		this.pageNum = pageNum;
		this.amount  = amount;
	}
}
