package com.javalec.ex;

public class BoardDto {
	
	public BoardDto() {
		
	}
	
	public BoardDto(int b_num, String b_title, String b_content, String b_user, String b_file) {
		super();
		this.b_num = b_num;
		this.b_title = b_title;
		this.b_content = b_content;
		this.b_user = b_user;
		this.b_file = b_file;
	}

	//변수 선언
	private int b_num;
	private String b_title,b_content,b_user,b_file;
	
	
	public int getB_num() {
		return b_num;
	}
	public void setB_num(int b_num) {
		this.b_num = b_num;
	}
	public String getB_title() {
		return b_title;
	}
	public void setB_title(String b_title) {
		this.b_title = b_title;
	}
	public String getB_content() {
		return b_content;
	}
	public void setB_content(String b_content) {
		this.b_content = b_content;
	}
	public String getB_user() {
		return b_user;
	}
	public void setB_user(String b_user) {
		this.b_user = b_user;
	}
	public String getB_file() {
		return b_file;
	}
	public void setB_file(String b_file) {
		this.b_file = b_file;
	}
	
	
	
	
}
