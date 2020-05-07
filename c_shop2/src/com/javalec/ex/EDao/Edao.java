package com.javalec.ex.EDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.javalec.ex.EDto.Edto;

public class Edao {

	public Edao(){
		try {
			context = new InitialContext();
			ds = (DataSource) context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	Context context;
	DataSource ds;
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
	String sql;
	public int eId, echeck;
	public String eTitle, eContent, eImg_thumb, eImg_cont;
	public String eDate1, eDate2;
	Edto edto;
	ArrayList<Edto> elist = new ArrayList<Edto>();
	
	
	
	//이벤트view
	public Edto eventView(int eId) {
		sql = "select * from event_board where eid=?";
		try {	
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, eId);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				eId = rs.getInt("eId");
				eTitle = rs.getString("eTitle");
				eContent = rs.getString("eContent");
				eImg_thumb = rs.getString("eImg_thumb");
				eImg_cont = rs.getString("eImg_cont");
				eDate1 = rs.getString("eDate1");
				eDate2 = rs.getString("eDate2");
				System.out.println(eDate2);
				edto = new Edto(eId, eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
				elist.add(edto);
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
		return edto;
	}
	
	
	//이벤트 등록
	public int eventRegi(String eTitle, String eContent,String eImg_thumb, String eImg_cont, String eDate1, String eDate2) {
		int check=0;
		System.out.println(eDate1);
		sql = "insert into event_board values (event_seq.nextval,?,?,?,?,?,?)";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eTitle);
			pstmt.setString(2, eContent);
			pstmt.setString(3, eImg_thumb);
			pstmt.setString(4, eImg_cont);
			pstmt.setString(5, eDate1);
			pstmt.setString(6, eDate2);
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
	
	//게시글 출력
	public ArrayList<Edto> eventList(int page, int limit){
		System.out.println("eventlist 들어옴");
		int endpost = page*limit;
		int startpost = endpost - limit + 1;
		sql="select * from "
				+ "(select rownum rnum,eid,etitle,econtent,eimg_thumb,eimg_cont,to_char(edate1,'yyyy-MM-dd') eDate1,to_char(edate2,'yyyy-MM-dd') eDate2 from "
				+ "(select * from event_board order by eid desc)) where rnum>=? and rnum<=? and edate2>=sysdate";
		try {	
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startpost);
			pstmt.setInt(2, endpost);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				eId = rs.getInt("eId");
				eTitle = rs.getString("eTitle");
				eContent = rs.getString("eContent");
				eImg_thumb = rs.getString("eImg_thumb");
				eImg_cont = rs.getString("eImg_cont");
				eDate1 = rs.getString("eDate1");
				eDate2 = rs.getString("eDate2");
				System.out.println(eDate2);
				edto = new Edto(eId, eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
				elist.add(edto);
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
		return elist;
	} //eventlist
	
	//게시글 카운트
	public int listCount() {
		int count=0;
		sql = "select count(*) as count from event_board where edate2>=sysdate";
		
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	}//list count
	
	
	
	//이하 어드민
	
	//어드민 이벤트 게시글 리스트 출력
	public ArrayList<Edto> eventList2(int page, int limit){
		System.out.println("eventlist 들어옴");
		int endpost = page*limit;
		int startpost = endpost - limit + 1;
		sql="select * from "
				+ "(select rownum rnum,eid,etitle,econtent,eimg_thumb,eimg_cont,to_char(edate1,'yyyy-MM-dd') eDate1,to_char(edate2,'yyyy-MM-dd') eDate2 from "
				+ "(select * from event_board order by eid desc)) where rnum>=? and rnum<=?";
		try {	
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, startpost);
			pstmt.setInt(2, endpost);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int rnum = rs.getInt("rnum");
				eId = rs.getInt("eId");
				eTitle = rs.getString("eTitle");
				eContent = rs.getString("eContent");
				eImg_thumb = rs.getString("eImg_thumb");
				eImg_cont = rs.getString("eImg_cont");
				eDate1 = rs.getString("eDate1");
				eDate2 = rs.getString("eDate2");
				System.out.println(eDate2);
				edto = new Edto(eId, eTitle, eContent, eImg_thumb, eImg_cont, eDate1, eDate2);
				edto.setRnum(rnum);
				elist.add(edto);
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
		return elist;
	} //eventlist2
	//어드민에서 게시글 카운트
	public int listCount_ad(int i) {
		int count=0;
		
		switch(i) {
		case 0 :
			sql = "select count(*) as count from event_board";
			break;
		case 1 : 
			sql = "select count(*) as count from event_board where edate2>=sysdate";
			break;
		}
		try {
			conn = ds.getConnection();
			pstmt = conn.prepareStatement(sql);
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
	}//list count
	
	
	
}
