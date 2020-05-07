package com.javalec.ex.Jcommand;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.MDao.Mdao;

public class Joinokcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Mdao mdao = new Mdao();
		String mname = request.getParameter("mname");
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mid");
		String memail = request.getParameter("memail");
		String memail2= request.getParameter("memail2");
		String maddress1= request.getParameter("maddress1");
		String maddress2= request.getParameter("maddress2");
		String mgender= request.getParameter("mgender");
		String mnews= request.getParameter("mnews");
		String msms= request.getParameter("msms");
		String mbirth = request.getParameter("mbirth");
		int mzonecode = Integer.parseInt(request.getParameter("mzonecode"));
		int mphone1 = Integer.parseInt(request.getParameter("mphone1"));
		int mphone2 = Integer.parseInt(request.getParameter("mphone2"));
		int mphone3 = Integer.parseInt(request.getParameter("mphone3"));
		
		int check = mdao.join(mname, mid, mpw, memail, memail2, mzonecode, maddress1, maddress2, mphone1, mphone2, mphone3, mbirth, mgender, mnews, msms);
		String view ="";
		if(check==0) {
			System.out.println("회원가입 실패");
			view = "join.jsp";
		} else {
			System.out.println("회원가입 성공");
			view = "join_scs.jsp";
			request.setAttribute("mid", mid);
		}
		request.setAttribute("check", check);
		request.setAttribute("view", view);
		
	}

}
