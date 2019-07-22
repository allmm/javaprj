package com.newlecture.web.entity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notice {
	private int id;
	private String title;
	private String content;
	private String writerId;
	private Date regDate;
	private int hit;
	
	public Notice() {
		// TODO Auto-generated constructor stub
	}

//	public Notice(String[] args) {
//		// TODO Auto-generated constructor stub
//		id =Integer.parseInt(args[0]);
//		this.title = args[1];
//		this.writerId = args[2];
//		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd");
//	      Date date=null;
//	      try {
//	         date = dt.parse(args[3]);
//	      } catch (ParseException e) {
//	         // TODO Auto-generated catch block
//	         e.printStackTrace();
//	      } 
//	      this.regDate = date;
//		//this.regDate = null;//new Date(args[3]);
//		this.hit = Integer.parseInt(args[4]);
//	}
	
	public Notice(int id, String title,String content, String writerId, Date regDate, int hit) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.writerId = writerId;
		this.regDate = regDate;
		this.hit = hit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getWriterId() {
		return writerId;
	}

	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
