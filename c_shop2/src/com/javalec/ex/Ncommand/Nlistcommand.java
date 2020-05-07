package com.javalec.ex.Ncommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.javalec.ex.Ndto.Ndto;

public class Nlistcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		Ndao ndao = new Ndao();
		ArrayList<Ndto> nlist = new ArrayList<Ndto>(); 
		
		String opt = request.getParameter("opt");
		String search = request.getParameter("search");
		String searchflag="";
		if(search!=null) {
			searchflag="1";
			request.setAttribute("searchflag", searchflag);
			request.setAttribute("opt", opt);
			request.setAttribute("search", search);
		}
		
		int page = 1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		int limit = 10;
		int range = 5;
		int listcount = ndao.listcount(opt, search);
		int maxpage = ((listcount-1)/limit)+1;
		int startpage = ((page-1)/range)*range+1;
		int endpage = startpage+range-1;
		if(endpage>maxpage) {
			endpage=maxpage;
		}
		request.setAttribute("listcount", listcount);
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		
		nlist = ndao.notilist(page, limit, opt, search);
		request.setAttribute("nlist", nlist);
		
		//검색여부
		//페이징
		//리스트출력
		
	}

}
