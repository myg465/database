package com.javalec.ex;

import java.sql.Timestamp;

public class MemberDto {

	public MemberDto() {

	}
	
	
	
	public MemberDto(int j_num, String id, String pw, String email, String address, Timestamp birth, String gender,
			String news, String sms, Timestamp j_date, String name, String phone) {
		
		this.j_num = j_num;
		this.id = id;
		this.pw = pw;
		this.email = email;
		this.address = address;
		this.birth = birth;
		this.gender = gender;
		this.news = news;
		this.sms = sms;
		this.j_date = j_date;
		this.name = name;
		this.phone = phone;
		
	}



	private int j_num;
	private String id;
	private String pw;
	private String email;
	private String address;
	private Timestamp birth;
	private String gender;
	private String news;
	private String sms;
	private Timestamp j_date;
	private String name;
	private String phone;
	
	
	public int getJ_num() {
		return j_num;
	}
	public void setJ_num(int j_num) {
		this.j_num = j_num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Timestamp getBirth() {
		return birth;
	}
	public void setBirth(Timestamp birth) {
		this.birth = birth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public String getSms() {
		return sms;
	}
	public void setSms(String sms) {
		this.sms = sms;
	}
	public Timestamp getJ_date() {
		return j_date;
	}
	public void setJ_date(Timestamp j_date) {
		this.j_date = j_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	
	
	
	

	
	
}
