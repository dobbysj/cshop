package com.javalec.ex.Ecommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.EDto.Edto;

public class EViewcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int eId = Integer.parseInt(request.getParameter("eId"));
		Edao edao = new Edao();
		Edto edto = edao.eventView(eId);
		
		request.setAttribute("event", edto);
		
	}

}
