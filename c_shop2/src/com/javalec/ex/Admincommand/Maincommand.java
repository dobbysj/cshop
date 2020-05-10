package com.javalec.ex.Admincommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.EDto.Edto;
import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.javalec.ex.Ndto.Ndto;

public class Maincommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Ndao ndao = new Ndao();
		Edao edao = new Edao();
		
		ArrayList<Edto> main_elist = new ArrayList<Edto>();
		ArrayList<Ndto> main_nlist = new ArrayList<Ndto>();
		
		main_elist = edao.eventList2(1, 5);
		main_nlist = ndao.notilist(1, 5, "", "");
		
		request.setAttribute("main_elist", main_elist);
		request.setAttribute("main_nlist", main_nlist);
		
		
		
	}

}
