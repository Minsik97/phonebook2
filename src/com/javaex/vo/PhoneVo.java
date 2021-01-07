package com.javaex.vo;

public class PhoneVo {
	//필드
	public int phoneId;
	public String name;
	public String hp;
	public String company;
	
	
	//생성자
	public PhoneVo() {}

	public PhoneVo(String name, String hp, String company) {
		super();
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	public PhoneVo(int phoneId, String hp, String company) {
		super();
		this.phoneId = phoneId;
		this.hp = hp;
		this.company = company;
	}

	public PhoneVo(int phoneId, String name, String hp, String company) {
		this.phoneId = phoneId;
		this.name = name;
		this.hp = hp;
		this.company = company;
	}
	
	
	//메소드 g/s
	public int getPhoneId() {
		return phoneId;
	}

	public void setPhoneId(int phoneId) {
		this.phoneId = phoneId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHp() {
		return hp;
	}

	public void setHp(String hp) {
		this.hp = hp;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}
	
	//메소드 일반
	@Override
	public String toString() {
		return "PhoneVo [phoneId=" + phoneId + ", name=" + name + ", hp=" + hp + ", company=" + company + "]";
	}
	
}
