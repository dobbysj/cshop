package com.javalec.ex.Ndao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.Ndto.Ndto;

public class Ndao {

	public Ndao() {
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//생성자
	
	//선언부
	String ntitle, ncontent, nattch;
	int nid, nhit, nrnum;
	Timestamp ndate;
	Context context;
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql="";
	Ndto ndto;
	ArrayList<Ndto> nlist = new ArrayList<Ndto>();
	
	
	public int upHit(int nid) {
		int check=0;
		sql="update noti_board set nhit=nhit+1 where nid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nid);
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
	
	
	//공지 하나 가져오기
	public Ndto notiview(int nid) {
		upHit(nid);
		sql = "select * from noti_board where nid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				ntitle = rs.getString("ntitle");
				ncontent = rs.getString("ncontent");
				nattch = rs.getString("nattch");
				nhit = rs.getInt("nhit");
				ndate = rs.getTimestamp("ndate");
				ndto = new Ndto(0, nid, ntitle, ncontent, nattch, ndate, nhit);
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
		return ndto;
	}
	
	
	//리스트 전체 출력하기
	public ArrayList<Ndto> notilist(int page, int limit, String opt, String search){
		
		int endrow = page*limit;
		int startrow = endrow-limit+1;
		
		if(opt==null) opt="";
		
		switch (opt) {
		case "":
			sql = "select * from "
					+ "(select rownum nrnum,nid,ntitle,ncontent,ndate,nhit,nattch from "
					+ "(select * from noti_board order by nid desc)) where nrnum>=? and nrnum<=?";
			break;
		case "all":
			sql = "select * from "
					+ "(select rownum nrnum,nid,ntitle,ncontent,ndate,nhit,nattch from "
					+ "(select * from noti_board where ntitle like '%'||?||'%' or ncontent like '%'||?||'%' order by nid desc)) where nrnum>=? and nrnum<=?";
			break;
		case "tit":
			sql = "select * from "
					+ "(select rownum nrnum,nid,ntitle,ncontent,ndate,nhit,nattch from "
					+ "(select * from noti_board where ntitle like '%'||?||'%' order by nid desc)) where nrnum>=? and nrnum<=?";
			break;
		case "cont":
			sql = "select * from "
					+ "(select rownum nrnum,nid,ntitle,ncontent,ndate,nhit,nattch from "
					+ "(select * from noti_board where ncontent like '%'||?||'%' order by nid desc)) where nrnum>=? and nrnum<=?";
			break;
		}
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(opt.equals("")) {
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
			} else if(opt.equals("all")) {
				pstmt.setString(1, search);
				pstmt.setString(2, search);
				pstmt.setInt(3, startrow);
				pstmt.setInt(4, endrow);
			} else {
				pstmt.setString(1, search);
				pstmt.setInt(2, startrow);
				pstmt.setInt(3, endrow);
			}
			rs = pstmt.executeQuery();
			while(rs.next()) {
				nrnum = rs.getInt("nrnum");
				nid = rs.getInt("nid");
				ntitle = rs.getString("ntitle");
				ncontent = rs.getString("ncontent");
				ndate = rs.getTimestamp("ndate");
				nhit = rs.getInt("nhit");
				nattch = rs.getString("nattch");
				ndto = new Ndto(nrnum, nid, ntitle, ncontent, nattch, ndate, nhit);
				nlist.add(ndto);
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
		return nlist;
	}//리스트전체출력
	
	//총 게시글 수(검색 게시글 수)
	public int listcount(String opt, String search) {
		int count = 0;
		
		if(opt==null) opt="";
		
		switch (opt) {
		case "":
			sql="select count(*) as count from noti_board";
			break;
		case "all":
			sql="select count(*) as count from noti_board where ntitle like '%'||?||'%' or ncontent like '%'||?||'%'";
			break;
		case "tit":
			sql="select count(*) as count from noti_board where ntitle like '%'||?||'%'";
			break;
		case "cont":
			sql="select count(*) as count from noti_board where ncont like '%'||?||'%'";
			break;
		}
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			if(opt.equals("all")) {
				pstmt.setString(1, search);
				pstmt.setString(2, search);
			} else if(opt.equals("tit")||opt.equals("cont")) {
				pstmt.setString(1, search);
			}
			rs = pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt("count");
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
		return count;
	}
	
	
	///////////이하 어드민//////////
	
	//어드민 공지 삭제 delete
	public int notiDelete(int nid) {
		int check = 0;
		sql = "delete from noti_board where nid=?";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, nid);
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
	
	//어드민 공지 수정 update
	public int notiModi(int nid, String ntitle, String ncontent, String nattch) {
		int check = 0;
		sql = "update noti_board set ntitle=?, ncontent=?, nattch=? where nid=?";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ntitle);
			pstmt.setString(2, ncontent);
			pstmt.setString(3, nattch);
			pstmt.setInt(4, nid);
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
	} //notiModi
	
	
	//어드민 공지 등록
	public int notiRegi(String ntitle, String ncontent, String nattch) {
		int check=0;
		sql = "insert into noti_board values (noti_seq.nextval,?,?,sysdate,0,?)";
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ntitle);
			pstmt.setString(2, ncontent);
			pstmt.setString(3, nattch);
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
	}//공지입력
	
	//어드민 공지 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
