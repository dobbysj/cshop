package com.javalec.ex.Ncommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.javalec.ex.Ndto.Ndto;

public class NAdModiViewcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int nid = Integer.parseInt(request.getParameter("nid"));
		
		Ndao ndao = new Ndao();
		Ndto ndto = ndao.notiview(nid);
		
		request.setAttribute("ndto", ndto);
		
	}

}
