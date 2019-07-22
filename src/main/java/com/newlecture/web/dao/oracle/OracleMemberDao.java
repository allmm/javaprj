package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import com.newlecture.web.dao.MemberDao;
import com.newlecture.web.entity.Member;


public class OracleMemberDao implements MemberDao {

	@Override
	public Member get(String id) throws ClassNotFoundException, SQLException {
		Member member = null;
		
		String sql=" select * from member where id= ? ";
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); //드라이버 로드// 동적 클래스 로드 (oracleDriver이라는 클래스를 로드하는것)

		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//db에 연결한다.
		
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);
		ResultSet rs = st.executeQuery();
		
		
		if(rs.next()) {
			member = new Member(
					 rs.getString("id")
					,rs.getString("pwd")
					,rs.getString("name")
					,rs.getInt("gender")
					,rs.getInt("age")
					,rs.getString("birthday")
					,rs.getString("phone")
					,rs.getDate("regdate")
					,rs.getString("boss_id")
					,rs.getString("type")
					);
		}
		
		rs.close();
		st.close();
		con.close();
		
		return member;
	}

	@Override
	public List<Member> getList(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
