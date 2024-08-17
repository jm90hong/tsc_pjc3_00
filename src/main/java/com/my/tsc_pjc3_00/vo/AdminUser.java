package com.my.tsc_pjc3_00.vo;

public class AdminUser {
	
	
	
	private int au_idx=0;
	private String id = null;
	private String pw = null;
	private String created_date=null;
	public int getAu_idx() {
		return au_idx;
	}
	public void setAu_idx(int au_idx) {
		this.au_idx = au_idx;
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
	public String getCreated_date() {
		return created_date;
	}
	public void setCreated_date(String created_date) {
		this.created_date = created_date;
	}
	
	
}
