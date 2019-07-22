package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.newlecture.web.entity.NoticeFile;

public class OracleNoticeFileDao implements com.newlecture.web.dao.NoticeFileDao {

	@Override
	public List<NoticeFile> getListByNoticeId(int noticeId) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		List<NoticeFile> list = new ArrayList<>();
		
		String sql ="SELECT * FROM NOTICE_FILE WHERE NOTICE_ID= ? ";
				
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드// 동적 클래스 로드 (oracleDriver이라는 클래스를 로드하는것)
		
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1,  noticeId);
		
		ResultSet rs = st.executeQuery();
		
		
		while(rs.next()) {
			NoticeFile noticeFile = new NoticeFile(
					 rs.getInt("id")
					,rs.getString("name")
					,rs.getInt("notice_id"));
					list.add(noticeFile);
		}
		
					
		rs.close();
		st.close();
		con.close();
		
		return list;
	}

	@Override
	public int insert(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result = 0;
		
		String sql =" insert into notice_file(id, name, notice_id) values(notice_file_seq.nextval,?,?) ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  noticeFile.getName());
		st.setInt(2, noticeFile.getNoticeId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int update(NoticeFile noticeFile) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		int result =0;
		
		String sql =" update notice_file set name=?, notice_id=? where id=? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1,  noticeFile.getName());
		st.setInt(2, noticeFile.getNoticeId());
		st.setInt(3,  noticeFile.getId());
		
		result = st.executeUpdate();
		
		st.close();
		con.close();
		
		return result;
	}

	@Override
	public int delete(int id) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 int result = 0;
	      
	      String sql = "DELETE NOTICE_FILE WHERE ID=?";
	      
	      String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
	      Class.forName("oracle.jdbc.driver.OracleDriver");
	      Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");
	      
	      PreparedStatement st  = con.prepareStatement(sql);      
	      st.setInt(1, id);
	      
	      result = st.executeUpdate();
	      
	      st.close();
	      con.close();
	      
	      return result;

	}

	

}
