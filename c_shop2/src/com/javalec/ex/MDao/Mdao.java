package com.javalec.ex.MDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.MDto.Mdto;

public class Mdao {

	//생성자
	public Mdao() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//선언부
	Context context;
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	Mdto mdto;
	ArrayList<Mdto> mlist = new ArrayList<Mdto>();
	String mname,mid,mpw,memail,memail2,maddress1,maddress2,mgender,mnews,msms;
	int mzonecode,mphone1,mphone2,mphone3;
	Timestamp mbirth;
	
	
	//회원가입
	public int join(String mname, String mid, String mpw, String memail, String memail2, int mzonecode, String maddress1, String maddress2, int mphone1, int mphone2, int mphone3, String mbirth, String mgender, String mnews, String msms) {
		int check =0;
		sql = "insert into c_member values(?,?,?,?,?,?,?,?,?,?,?,to_date(?,'yy-MM-dd'),?,?,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mname);
			pstmt.setString(2, mid);
			pstmt.setString(3, mpw);
			pstmt.setString(4, memail);
			pstmt.setString(5, memail2);
			pstmt.setInt(6, mzonecode);
			pstmt.setString(7, maddress1);
			pstmt.setString(8, maddress2);
			pstmt.setInt(9, mphone1);
			pstmt.setInt(10, mphone2);
			pstmt.setInt(11, mphone3);
			pstmt.setString(12, mbirth);
			pstmt.setString(13, mgender);
			pstmt.setString(14, mnews);
			pstmt.setString(15, msms);
			check = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return check;
	}
	
	
	//회원가입시 아이디 중복 확인
	public int checkId(String mid) {
		int check = 0;
		sql="select mid from c_member where mid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				check = 1;
			} else {
				check = 0;
			}
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
	}
	
	
	//회원 1명 정보 가져오기
	public Mdto getMember(String mid) {
		sql="select * from c_member where mid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				mname = rs.getString("mname");
				mid = rs.getString("mid");
				mpw = rs.getString("mpw");
				memail = rs.getString("memail");
				memail2 = rs.getString("memail2");
				mzonecode = rs.getInt("mzonecode");
				maddress1 = rs.getString("maddress1");
				maddress2 = rs.getString("maddress2");
				mgender = rs.getString("mgender");
				mnews = rs.getString("mnews");
				msms = rs.getString("msms");
				mphone1 = rs.getInt("mphone1");
				mphone2 = rs.getInt("mphone2");
				mphone3 = rs.getInt("mphone3");
				mbirth = rs.getTimestamp("mbirth");
				mdto = new Mdto(mname, mid, mpw, memail, memail2, mzonecode, maddress1, maddress2, mphone1, mphone2, mphone3, mbirth, mgender, mnews, msms);
			}
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
		return mdto;
	}
	
	//로그인 체크
	public int loginCheck(String mid, String mpw) {
		int check=0;
		String dbid, dbpw;
		sql="select * from c_member where mid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dbid = rs.getString("mid");
				dbpw = rs.getString("mpw");
				if(dbpw.equals(mpw)) {
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
