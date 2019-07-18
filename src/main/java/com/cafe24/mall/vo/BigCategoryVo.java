package com.cafe24.mall.vo;

import org.hibernate.validator.constraints.Length;

public class BigCategoryVo {
	
	private Long no;
	
	@Length(max = 10)
	private String name;
	
	private int presult;
	
	
	public int getPresult() {
		return presult;
	}
	public void setPresult(int presult) {
		this.presult = presult;
	}
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "BigCategoryVo [no=" + no + ", name=" + name + "]";
	}
	
	
	

}
