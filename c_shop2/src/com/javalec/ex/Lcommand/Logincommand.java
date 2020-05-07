package com.javalec.ex.Lcommand;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.MDao.Mdao;
import com.javalec.ex.MDto.Mdto;

public class Logincommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		HttpSession session = request.getSession();
				
		Mdao mdao=new Mdao();
		Mdto mdto;
		int check = mdao.loginCheck(mid, mpw);
		String view="";
		request.setAttribute("check", check);
		if(check==-1) {
			//아이디 없음
			view="login.jsp";
			request.setAttribute("logok", "아이디가 존재하지 않습니다.");
		} else if(check==0) {
			//비번이 일치하지 않음
			view="login.jsp";
			request.setAttribute("logok", "패스워드가 일치하지 않습니다.");
		} else if(check==1) {
			//로그인 성공
			view="main.jsp";
			request.setAttribute("logok", "null");
			mdto = mdao.getMember(mid);
			session.setAttribute("mid", mid);
			session.setAttribute("authUser", mid);
			session.setAttribute("name", mdto.getMname());
		}
		request.setAttribute("view", view);
	}

}
