package com.newlecture.web.dao.oracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import org.eclipse.jdt.internal.compiler.parser.Scanner;

import com.newlecture.dao.JdbcMemberDao;

public class Program {

	public static void main(String[] args) {
		JdbcMemberDao jmd = new JdbcMemberDao();
		System.out.println(jmd.get("nelec").getId());
	}

}


/*		
		String url = "jdbc:oracle:thin:@192.168.0.15:1521/xepdb1";
		String sql = "select * from member where id like '%e%'";
		
		Connection con = DriverManager.getConnection(url, "\"newlec\"", "l4class");//
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
			String pwd = rs.getString("PWD");
			String id = rs.getString("ID");
			String name = rs.getString("NAME");
			if(rs.getString("ID").contains("e"))
				System.out.printf("id : %s  pwd : %s  NAME : %s\n",id,pwd,name);
		}
		
		rs.close();
		st.close();
		con.close();
 */				