package com.javalec.ex.Ncommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;

public class NAdDelcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int nid = Integer.parseInt(request.getParameter("nid"));
		
		Ndao ndao = new Ndao();
		int check = ndao.notiDelete(nid);
		System.out.println("삭제성공? "+check);
	}

}
