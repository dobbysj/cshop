package com.javalec.ex.Admincommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.javalec.ex.Adao.Adao;
import com.javalec.ex.Adto.Adto;
import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.MDao.Mdao;
import com.javalec.ex.MDto.Mdto;

public class AdLogincommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String aid = request.getParameter("aid");
		String apw = request.getParameter("apw");
		HttpSession session = request.getSession();
			
		Adao adao = new Adao();
		Adto adto;
		
		int check = adao.loginCheck(aid, apw);
		String view="";
		request.setAttribute("check", check);
		if(check==-1) {
			//아이디 없음
			view="ad_login.jsp";
			request.setAttribute("logok", "아이디가 존재하지 않습니다.");
		} else if(check==0) {
			//비번이 일치하지 않음
			view="ad_login.jsp";
			request.setAttribute("logok", "패스워드가 일치하지 않습니다.");
		} else if(check==1) {
			//로그인 성공
			view="ad_main.do";
			request.setAttribute("logok", "null");
			session.setAttribute("aid", aid);
		}
		request.setAttribute("view", view);
		
	}

}
