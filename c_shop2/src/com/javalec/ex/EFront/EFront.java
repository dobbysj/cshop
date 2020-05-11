package com.javalec.ex.EFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Admincommand.AdLogincommand;
import com.javalec.ex.Admincommand.AdLogoutcommand;
import com.javalec.ex.Admincommand.Maincommand;
import com.javalec.ex.Ecommand.EAdDelcommand;
import com.javalec.ex.Ecommand.EAdListcommand;
import com.javalec.ex.Ecommand.EAdModiViewcommand;
import com.javalec.ex.Ecommand.EAdModifycommand;
import com.javalec.ex.Ecommand.EListcommand;
import com.javalec.ex.Ecommand.ERegicommand;
import com.javalec.ex.Ecommand.EViewcommand;
import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Jcommand.JoinCheckcommand;
import com.javalec.ex.Jcommand.Joinokcommand;
import com.javalec.ex.Lcommand.Logincommand;
import com.javalec.ex.Lcommand.Logoutcommand;
import com.javalec.ex.Mcommand.MAdListcommand;
import com.javalec.ex.Ncommand.NAdDelcommand;
import com.javalec.ex.Ncommand.NAdListcommand;
import com.javalec.ex.Ncommand.NAdModiViewcommand;
import com.javalec.ex.Ncommand.NAdModifycommand;
import com.javalec.ex.Ncommand.NRegicommand;
import com.javalec.ex.Ncommand.Nlistcommand;
import com.javalec.ex.Ncommand.Nviewcommand;

@WebServlet("*.do")
public class EFront extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EFront() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		actionDo(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("dopost");
		actionDo(request, response);
	}
	
	protected void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("actiondo");
		
		String pageView = null;
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String com = uri.substring(path.length());
		Ecommand ecmd;
		
		//메인
		if(com.equals("/main.do")) {
			pageView = "main.jsp"; //메인
		} 

		
		//어드민 메인
		if(com.equals("/ad_main.do")) {
			ecmd = new Maincommand();
			ecmd.execute(request, response);
			pageView="ad_main.jsp"; //어드민 메인
		}
		
		
		//로그인아웃
		if(com.equals("/loginok.do")) {
			ecmd = new Logincommand();
			ecmd.execute(request, response);
			String view = (String)request.getAttribute("view");
			pageView = view; //로그인 시 메인 혹은 로그인창 분기
		} else if(com.equals("/loginview.do")) {
			request.setAttribute("check", 2);
			pageView = "login.jsp"; //로그인 클릭시 로그인 페이지로
		} else if(com.equals("/logout.do")) {
			ecmd = new Logoutcommand();
			ecmd.execute(request, response);
			pageView = "main.jsp"; //로그아웃 > 메인
		}
		
		
		//어드민 로그인아웃
		if(com.equals("/adminLogin.do")) {
			ecmd = new AdLogincommand();
			ecmd.execute(request, response);
			String view = (String)request.getAttribute("view");
			pageView = view;
		} else if(com.equals("/adminLogout.do")) {
			ecmd = new AdLogoutcommand();
			ecmd.execute(request, response);
			pageView = "ad_login.jsp";
		}
		

		//회원가입
		if(com.equals("/joinview.do")) {
			request.setAttribute("check", 2);
			pageView = "join.jsp"; //회원가입 클릭 시 회원가입 페이지로
		} else if(com.equals("/join_check.do")) {
			ecmd = new JoinCheckcommand();
			ecmd.execute(request, response);
			pageView = "join_idcheck.jsp"; //회원가입 부모창에서 중복체크 클릭 시 아이디 체크 자식 새창
		} else if(com.equals("/joinok.do")) {
			ecmd = new Joinokcommand();
			ecmd.execute(request, response);
			String view = (String)request.getAttribute("view");
			pageView = view; //회원가입 시 회원가입 성공 혹은 회원가입창 분기
		} 
		
		
		//어드민 회원관리
		if(com.equals("/ad_mem_list.do")) {
			ecmd = new MAdListcommand();
			ecmd.execute(request, response);
			pageView = "ad_mem_list.jsp";
		}
		
		
		
		//이벤트
		if(com.equals("/eventlist.do")) {
			ecmd = new EListcommand();
			ecmd.execute(request, response);
			pageView = "event_list.jsp"; //이벤트리스트
		} else if(com.equals("/eventregiview.do")) {
			pageView = "ad_ev_input.jsp"; //어드민 이벤트등록페이지로
		} else if(com.equals("/eventregi.do")) {
			ecmd = new ERegicommand();
			ecmd.execute(request, response);
			pageView = "ad_ev_list.do"; //어드민 이벤트 등록 > 어드민 이벤트리스트
		} else if(com.equals("/ad_ev_modify.do")) {
			ecmd = new EAdModiViewcommand();
			ecmd.execute(request, response);
			pageView = "ad_ev_modify.jsp";
		} else if(com.equals("/eventmodi.do")) {
			ecmd = new EAdModifycommand();
			ecmd.execute(request, response);
			pageView = "ad_ev_list.do"; //이벤트 수정 후 어드민 이벤트 리스트로
		} else if(com.equals("/ad_ev_list.do")) {
			ecmd = new EAdListcommand();
			ecmd.execute(request, response);
			pageView = "ad_event_list.jsp"; //어드민 이벤트리스트
		} else if(com.equals("/eventview.do")) {
			ecmd = new EViewcommand();
			ecmd.execute(request, response);
			pageView = "event_view.jsp"; //이벤트 상세
		} else if(com.equals("/ad_ev_del.do")) {
			ecmd = new EAdDelcommand();
			ecmd.execute(request, response);
			pageView = "ad_ev_list.do";
		}
		
		//공지관련
		if(com.equals("/notilist.do")) {
			ecmd = new Nlistcommand();
			ecmd.execute(request, response);
			pageView = "notice.jsp";//공지사항 리스트
		} else if(com.equals("/search.do")) {
			ecmd = new Nlistcommand();
			ecmd.execute(request, response);
			pageView = "notice.jsp"; //공지사항 검색 결과 리스트
		} else if(com.equals("/notiregi.do")) {
			ecmd = new NRegicommand();
			ecmd.execute(request, response);
			pageView = "ad_noti_list.do"; //어드민 공지 등록 > 어드민 공지 리스트
		} else if(com.equals("/ad_noti_list.do")) {
			ecmd = new NAdListcommand();
			ecmd.execute(request, response);
			pageView = "ad_noti_list.jsp"; //어드민 공지 리스트
		} else if(com.equals("/notiregiview.do")) {
			pageView = "ad_noti_input.jsp"; //어드민 공지 등록 페이지
		} else if(com.equals("/ad_noti_modify.do")) {
			ecmd = new NAdModiViewcommand();
			ecmd.execute(request, response);
			pageView = "ad_noti_modify.jsp";//어드민 공지 수정 화면으로 이동
		} else if(com.equals("/notimodi.do")) {
			ecmd = new NAdModifycommand();
			ecmd.execute(request, response);
			pageView = "ad_noti_list.do";  //어드민 공지 수정 후 어드민 공지 리스트로 이동
		} else if(com.equals("/ad_noti_del.do")) {
			ecmd = new NAdDelcommand();
			ecmd.execute(request, response);
			pageView = "ad_noti_list.do"; //어드민 공지 삭제 후 어드민 공지 리스트로 이동
		} else if(com.equals("/ad_main.do")) {
			pageView = "ad_main.jsp"; //어드민 메인 
		} else if(com.equals("/notice_view.do")) {
			ecmd = new Nviewcommand();
			ecmd.execute(request, response);
			pageView = "noti_view.jsp";
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
	}

}
