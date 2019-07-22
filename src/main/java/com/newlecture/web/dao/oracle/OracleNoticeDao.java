package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.newlecture.web.dao.NoticeDao;
import com.newlecture.web.entity.Notice;
import com.newlecture.web.entity.Noticeview;

@Repository
public class OracleNoticeDao implements NoticeDao{
	
	@Override
	public List<Noticeview> getList() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(1,"title","");
	}
	@Override
	public List<Noticeview> getList(int page) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getList(page,"title","");
	}
	@Override
	public List<Noticeview> getList(int page, String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<Noticeview> list = new ArrayList<>();
		
		int start =(page-1)*10+1;
		int end =start+9;
		
		String sql ="SELECT * FROM NOTICE_VIEW " + 
				"WHERE "+field+" LIKE ? AND NUM BETWEEN ? AND ?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드// 동적 클래스 로드 (oracleDriver이라는 클래스를 로드하는것)
		
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setString(1,  "%"+query+"%");
		st.setInt(2,  start);
		st.setInt(3,  end);
		
		
		ResultSet rs = st.executeQuery();
		
		
		
		while(rs.next()) {
			Noticeview notice = new Noticeview(
					 rs.getInt("id")
					,rs.getString("title")
					,""
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit")
					,rs.getInt("comment_count"));
					list.add(notice);
		}
		
					
		rs.close();
		st.close();
		con.close();
		
		return list;
	}
	@Override
	public Notice get(int id) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Notice notice = null;
		
		String sql=" select * from notice where id= "+id;
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드// 동적 클래스 로드 (oracleDriver이라는 클래스를 로드하는것)

		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//db에 연결한다.
		Statement st = con.createStatement();//next의 의미 : 읽어올때 데이터의 처음부터 읽어오므로 next를 만나면 
											 //한 로우를 읽어오고 다음로우로 내려간다. next하면 한줄한줄 내려가면서 
											 //데이터를 가져오게 하는 역할 끝까지 가서 next를 만나면 반복이 끝난다.
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	@Override
	public Notice getPrev(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Notice notice =null;
		String sql = " select * from notice_view "
				+ "	where regdate < (select regdate from notice where id=' "+id+" ') and rownum = 1 ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,""//rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	@Override
	public Notice getNext(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Notice notice =null;
		String sql =" select* from (select * from (select * from notice_view order by regdate) "
				+ " where regdate > (select regdate from notice where id ="+id+")) where  rownum=1 ";
		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			notice = new Notice(
					 rs.getInt("id")
					,rs.getString("title")
					,""//rs.getString("content")
					,rs.getString("writer_id")
					,rs.getDate("regDate")
					,rs.getInt("hit"));
		}
		
		rs.close();
		st.close();
		con.close();
		
		return notice;
	}
	
	@Override
	public int insert(Notice notice) throws ClassNotFoundException, SQLException {
		
		int result = 0;
		
		String sql =" insert into notice(id, title, content, writer_id) values(notice_seq.nextval,?,?,'jun') ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  notice.getTitle());
		st.setString(2, notice.getContent());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	public int update(Notice notice) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result =0;
		
		String sql =" update notice set title=?, content=? where id=? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  notice.getTitle());
		st.setString(2, notice.getContent());
		st.setInt(3,  notice.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	
	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result =0;
		
		String sql =" delete from notice where id=? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		                                                                                                                                 
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}
	@Override
	public int getLastId() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		String sql = "select id from (select * from notice order by regdate desc) where rownum = 1 ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		int id=-1;
		
		if(rs.next()) {
			id=rs.getInt("id");
		}
		
		rs.close();
		st.close();
		con.close();
		
		return id;
	}
	@Override
	public int getCount() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return getCount("title","");
	}
	@Override
	public int getCount(String field, String query) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		int count=0;
		
		String sql = "select count(id) count from notice where "+field+" like ?";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%"+query+"%");
		ResultSet rs = st.executeQuery(sql);
		
		if(rs.next()) {
			count=rs.getInt("count");
		}                                                                                                                                 
		
		rs.close();
		st.close();
		con.close();
		
		return count;
	}
}
