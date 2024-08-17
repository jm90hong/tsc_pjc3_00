package com.my.tsc_pjc3_00.vo;

public class Item {
	
	private int item_idx=0;
	private String item_code=null;
	private String item_name=null;
	private String item_img = null;
	private String item_type = null;
	private String item_process = null;
	private String item_content = null;
	private String item_created_date = null;
	
	private int user_idx=0;
	
	
	//페이지 네이션
	private int start=0;
	private int count=0;
	
	

	
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getItem_content() {
		return item_content;
	}
	public void setItem_content(String item_content) {
		this.item_content = item_content;
	}
	public int getItem_idx() {
		return item_idx;
	}
	public void setItem_idx(int item_idx) {
		this.item_idx = item_idx;
	}
	public String getItem_code() {
		return item_code;
	}
	public void setItem_code(String item_code) {
		this.item_code = item_code;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_img() {
		return item_img;
	}
	public void setItem_img(String item_img) {
		this.item_img = item_img;
	}
	public String getItem_type() {
		return item_type;
	}
	public void setItem_type(String item_type) {
		this.item_type = item_type;
	}
	public String getItem_process() {
		return item_process;
	}
	public void setItem_process(String item_process) {
		this.item_process = item_process;
	}
	public String getItem_created_date() {
		return item_created_date;
	}
	public void setItem_created_date(String item_created_date) {
		this.item_created_date = item_created_date;
	}
	
	
	
	
	
}
