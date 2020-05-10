package com.javalec.ex.Adao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.Adto.Adto;

public class Adao {

	public Adao() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	//선언부
		int anum, level;
		String aid, apw;
		Context context;
		DataSource ds;
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		String sql="";
		Adto adto;
		ArrayList<Adto> alist = new ArrayList<Adto>();
	
		
	
		
		//로그인 체크
		public int loginCheck(String aid, String apw) {
			int check=0;
			String dbid, dbpw;
			sql="select * from c_admin where aid=?";
			try {
				conn = ds.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, aid);
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					dbid = rs.getString("aid");
					dbpw = rs.getString("apw");
					if(dbpw.equals(apw)) {
						check=1;//아이디,비번 일치
					} else {
						check=0;//비번 불일치
					}
				} else {
					check=-1;//아이디 없음
				}//rs if문
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt!=null) pstmt.close();
					if(conn!=null) conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return check;
		}//loginCheck
		
	
}
