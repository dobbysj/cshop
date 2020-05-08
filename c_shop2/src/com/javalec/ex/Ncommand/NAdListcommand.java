package com.javalec.ex.Ncommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.javalec.ex.EDao.Edao;
import com.javalec.ex.EDto.Edto;
import com.javalec.ex.Ecommand.Ecommand;
import com.javalec.ex.Ndao.Ndao;
import com.javalec.ex.Ndto.Ndto;

public class NAdListcommand implements Ecommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		Ndao ndao = new Ndao();
		//페이징 관련 
		//출력할 페이지
		int page=1;
		if(request.getParameter("page")!=null) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		//페이지당 게시물수
		int limit=10;
		//페이지 레인지
		int range=10;
		//전체 게시글 카운트
		int listcount = ndao.listcount("", "");
		System.out.println("listcount"+listcount);
		//전체 레인지의 최종 페이지 넘버
		int maxpage = ( (listcount - 1) / limit ) + 1;
		System.out.println("maxpage"+maxpage);
		//한 레인지의 처음 페이지 넘버
		int startpage = ((page-1)/range)*range+1;
		//한 레인지의 마지막 페이지넘버
		int endpage = maxpage;
		if(endpage>startpage+range-1) endpage = startpage+range-1;
		System.out.println("endpage"+endpage);
		
		
		//출력 관련
		ArrayList<Ndto> nlist = new ArrayList<Ndto>();
		nlist = ndao.notilist(page, limit, "","");
		System.out.println("사이즈 : "+nlist.size());
		
		//리퀘스트에 담아 보내기
		request.setAttribute("nlist", nlist);
		request.setAttribute("page", page);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("listcount", listcount);
		
	}

}
