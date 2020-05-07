package com.javalec.ex.EFront;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.EAdListcommand;
import com.javalec.ex.Ecommand.EListcommand;
import com.javalec.ex.Ecommand.ERegicommand;
import com.javalec.ex.Ecommand.EViewcommand;
import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Jcommand.JoinCheckcommand;
import com.javalec.ex.Jcommand.Joinokcommand;
import com.javalec.ex.Lcommand.Logincommand;
import com.javalec.ex.Lcommand.Logoutcommand;
import com.javalec.ex.Ncommand.Nlistcommand;

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
		//커맨드 인터페이스 / 각각의 커맨드 만들기 
		if(com.equals("/eventlist.do")) {
			ecmd = new EListcommand();
			ecmd.execute(request, response);
			pageView = "event_list.jsp";
		} else if(com.equals("/eventregiview.do")) {
			pageView = "ad_ev_input.jsp";
		} else if(com.equals("/eventregi.do")) {
			ecmd = new ERegicommand();
			ecmd.execute(request, response);
			pageView = "ad_ev_list.do";
		} else if(com.equals("/ad_ev_list.do")) {
			ecmd = new EAdListcommand();
			ecmd.execute(request, response);
			pageView = "ad_event_list.jsp";
		} else if(com.equals("/eventview.do")) {
			ecmd = new EViewcommand();
			ecmd.execute(request, response);
			pageView = "event_view.jsp";
		} else if(com.equals("/loginok.do")) {
			ecmd = new Logincommand();
			ecmd.execute(request, response);
			String view = (String)request.getAttribute("view");
			pageView = view;
		} else if(com.equals("/loginview.do")) {
			request.setAttribute("check", 2);
			pageView = "login.jsp";
		} else if(com.equals("/joinview.do")) {
			request.setAttribute("check", 2);
			pageView = "join.jsp";
		} else if(com.equals("/join_check.do")) {
			ecmd = new JoinCheckcommand();
			ecmd.execute(request, response);
			pageView = "join_idcheck.jsp";
		} else if(com.equals("/joinok.do")) {
			ecmd = new Joinokcommand();
			ecmd.execute(request, response);
			String view = (String)request.getAttribute("view");
			pageView = view;
		} else if(com.equals("/main.do")) {
			pageView = "main.jsp";
		} else if(com.equals("/logout.do")) {
			ecmd = new Logoutcommand();
			ecmd.execute(request, response);
			pageView = "main.jsp";
		} else if(com.equals("/notilist.do")) {
			ecmd = new Nlistcommand();
			ecmd.execute(request, response);
			pageView = "notice.jsp";
		} else if(com.equals("/search.do")) {
			ecmd = new Nlistcommand();
			ecmd.execute(request, response);
			pageView = "notice.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(pageView);
		dispatcher.forward(request, response);
		
	}

}
