package com.javalec.ex.Jcommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.MDao.Mdao;
import com.javalec.ex.MDto.Mdto;

public class JoinCheckcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String mid2 = request.getParameter("mid2");
		Mdao mdao = new Mdao();
		int idcheck = mdao.checkId(mid2);
		request.setAttribute("idcheck", idcheck);
		request.setAttribute("mid2", mid2);
	}

}
