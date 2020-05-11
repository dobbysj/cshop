package com.javalec.ex.Mcommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.MDao.Mdao;
import com.javalec.ex.MDto.Mdto;

public class MAdListcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Mdao mdao = new Mdao();
		
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		//페이지당 게시물수
		int limit=10;
		//페이지 레인지
		int range=10;
		//전체 게시글 카운트
		int listcount = mdao.memcount("", "");
		System.out.println("listcount"+listcount);
		//전체 레인지의 최종 페이지 넘버
		int maxpage = ( (listcount - 1) / limit ) + 1;
		//한 레인지의 처음 페이지 넘버
		int startpage = ((page-1)/range)*range+1;
		//한 레인지의 마지막 페이지넘버
		int endpage = maxpage;
		if(endpage>startpage+range-1) endpage = startpage+range-1;
		
		ArrayList<Mdto> mlist = new ArrayList<Mdto>();
		mlist = mdao.memlist(page, limit,"","");
		
		
		request.setAttribute("mlist", mlist);
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("listcount", listcount);
		
		
	}

}
