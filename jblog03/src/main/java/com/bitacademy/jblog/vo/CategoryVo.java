package com.bitacademy.jblog.vo;

public class CategoryVo {
	private Long no;
	private String title;
	private String descr;
	private String id;
	
	public Long getNo() {
		return no;
	}
	
	public void setNo(Long no) {
		this.no = no;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
		
	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", title=" + title + ", descr=" + descr + ", id=" + id + "]";
	}

	
}