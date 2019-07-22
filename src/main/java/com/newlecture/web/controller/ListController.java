package com.newlecture.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.dao.oracle.OracleNoticeDao;

public class ListController implements Controller {

	
	 // @Autowired private NoticeDao noticeDao;
	 
	
	/*public void setNoticeDao(NoticeDao noticeDao) {
		this.noticeDao = noticeDao;
	}*/

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//NoticeDao noticeDao = new OracleNoticeDao();
		
		/* List<Noticeview> list = noticeDao.getList(); */
		
		ModelAndView mv = new ModelAndView("notice/list");
		
		mv.addObject("x", "공지사항 목록입니다.");

		return mv;
	}

	
}