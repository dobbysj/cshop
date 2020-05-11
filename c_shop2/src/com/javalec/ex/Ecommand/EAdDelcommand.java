package com.javalec.ex.Ecommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.Ndao.Ndao;

public class EAdDelcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int eId = Integer.parseInt(request.getParameter("eId"));
		
		Edao edao = new Edao();
		int check = edao.evDelete(eId);
		
		System.out.println("삭제성공? "+check);
		
	}

}
