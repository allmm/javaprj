package com.newlecture.web.controller;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Noticeview;


@Controller
@RequestMapping("/notice/")
public class NoticeController {
	
	@Autowired
	private NoticeDao noticeDao;
	
	
	
	//입력 방법 2 : 스프링을 이용한 입력 방법
	@RequestMapping("list")
	public String noticeList(Model model
			, @RequestParam(name="p", defaultValue="1") Integer page
			) throws ClassNotFoundException, SQLException {
		
		
		List<Noticeview> list = noticeDao.getList();
		
		model.addAttribute("list", list);
		
		System.out.println("리스트 요청");
		
		return "notice/list";
	}
	
	/*
	@RequestMapping("list")
	public String noticeList(Model model, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		int page = 1;
		String p = request.getParameter("p");
		if(p != null && p.contentEquals(""))
			page = Integer.parseInt(p);
		
				
		List<Noticeview> list = noticeDao.getList();
		
		model.addAttribute("list", list);
		
		System.out.println("리스트 요청");
		
		return "notice/list";
	}
	*/
	
}
