package com.bitacademy.jblog.vo;

public class CategoryVo {
	private Long no;
	private String title;
	private String descr;
	private String id;
	private Long postNo;
	
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
	
	

	public Long getPostNo() {
		return postNo;
	}

	public void setPostNo(Long postNo) {
		this.postNo = postNo;
	}

	@Override
	public String toString() {
		return "CategoryVo [no=" + no + ", title=" + title + ", descr=" + descr + ", id=" + id + ", postNo=" + postNo
				+ "]";
	}

	
	
}