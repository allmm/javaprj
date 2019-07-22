package com.newlecture.web.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.newlecture.web.entity.Noticeview;
import com.newlecture.web.entity.Notice;

public interface NoticeDao {

	int getCount() throws ClassNotFoundException, SQLException;
	int getCount(String field, String query) throws ClassNotFoundException, SQLException;
	
	List<Noticeview> getList() throws ClassNotFoundException, SQLException;//목록 로드될때
	List<Noticeview> getList(Integer page) throws ClassNotFoundException, SQLException;//페이징할떄
	/*
	 * @Select("SELECT * FROM NOTICE_VIEW" +" WHERE ${field} LIKE '%${query}%'"
	 * +" AND NUM BETWEEN 1+(${page}-1)*10 AND #{page}*10")
	 */
	List<Noticeview> getList(@Param("page") Integer page, @Param("field") String field, @Param("query") String query) throws ClassNotFoundException, SQLException;//검색할때
	
//	@Select("select * from notice where id = #{id}")
	Notice get(int id) throws SQLException, ClassNotFoundException;//내용 로드될때
	Notice getPrev(int id) throws ClassNotFoundException, SQLException;
	Notice getNext(int id) throws ClassNotFoundException, SQLException;
	
	int insert(Notice notice) throws ClassNotFoundException, SQLException;
	int update(Notice notice) throws ClassNotFoundException, SQLException;
	int delete(int id) throws ClassNotFoundException, SQLException;
	int getLastId() throws ClassNotFoundException, SQLException;
}
