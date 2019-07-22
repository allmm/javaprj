package com.newlecture.web.entity;

import java.util.Date;

import com.newlecture.web.entity.Notice;

public class Noticeview extends Notice {
	
	private int commentCount;
	
	public Noticeview() {
		// TODO Auto-generated constructor stub
	}
	
	public Noticeview(int id, String title,String content, String writerId, Date regDate, int hit, int commentCount) {
		// TODO Auto-generated constructor stub
	super(id, title, content, writerId, regDate, hit);
	this.commentCount = commentCount;
	}
	
	public int getCommentCount() {
		return commentCount;
	}
	
	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
}
